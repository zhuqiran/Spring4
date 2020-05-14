1. Spring 与JDBCTemplate(JDBC模板)
    为了避免直接使用JDBC而带来的复杂且冗长的代码，Spring提供了一个强有力的模板类---JdbcTemplate
来简化JDBC操作。并且，数据源DataSource对象与模板JdbcTemplate对象均可通过Bean的形式定义在配置文件中，
充分发挥了依赖注入的威力。

2. 环境搭建
    除了Spring的基本Jar包，数据库驱动Jar外，还需要导入两个Jar包。它们均在Spring框架解压目录下的libs目录中。
    spring-jdbc-4.2.1.release.jar       // Spring的JDBC jar包
    spring-ex.4.2.1.release.jar         // spring的事务支持jar包

3. 配置JdbcTemplate对象
 <!--配置数据库连接池-->
    <!--spring默认连接池-->
   <!-- <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <property name="driverClassName" value="com.mysql.cj.jdbc.Driver"/>
        <property name="url" value="jdbc:mysql://127.0.0.1:3306/test?serverTimezone=UTC"/>
        <property name="username" value="root"/>
        <property name="password" value="zhuqiran"/>
    </bean>-->

    <!--c3p0连接池-->
    <!--<bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
        <property name="driverClass" value="com.mysql.cj.jdbc.Driver"/>
        <property name="jdbcUrl" value="jdbc:mysql://127.0.0.1:3306/test?serverTimezone=UTC"/>
        <property name="user" value="root"/>
        <property name="password" value="zhuqiran"/>
    </bean>-->

    <!--dbcp数据库连接池-->
    <bean id="dataSource" class="org.apache.commons.dbcp2.BasicDataSource">
        <property name="driverClassName" value="com.mysql.cj.jdbc.Driver"/>
        <property name="url" value="jdbc:mysql://127.0.0.1:3306/test?serverTimezone=UTC"/>
        <property name="username" value="root"/>
        <property name="password" value="zhuqiran"/>
    </bean>

    <!--配置JdbcTemplate对象-->
    <bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
        <!--配置数据源属性值-->
        <property name="dataSource" ref="dataSource"/>
    </bean>

 4. 使用JdbcTemplate对象进行数据库的增删查改操作
    /**
     *  继承JdbcDaoSupport类，通过getJdbcTemplate方法得到JDBCTemplate对象，
     *  然后通过JDBCTemplate对象进行数据操作
     *
     *  值得注意的是，增、删、改操作都是通过JdbcTemplate对象的update()方法完成的。查询通过其query()方法完成
     */

    public class StudentDao extends JdbcDaoSupport implements IStudentDao {
        @Override
        public int insertStudent(Student student) {
            String sql = "insert into student(name, age, score) values(?, ?, ?)";
            int count = this.getJdbcTemplate().update(sql, student.getName(), student.getAge(), student.getScore());
            return count;
        }

        @Override
        public int deleteStudent(int id) {
            String sql = "delete from student where id = ?";
            int count = this.getJdbcTemplate().update(sql, id);
            return count;
        }

        @Override
        public int updateStudent(Student student) {
            String sql = "update student set name = ?, age = ?, score = ? where id = ?";
            int count = this.getJdbcTemplate().update(sql, student.getName(), student.getAge(), student.getScore(), student.getId());
            return count;
        }
    }
 5. 使用JdbcTemplate对象进行查询操作
    @Override
     public List<String> selectAllNames() {
         String sql = "select name from student";
         // 第二个参数为查询元素类型的字节码类型
         List<String> names = this.getJdbcTemplate().queryForList(sql, String.class);
         return names;
     }

    在查询自定义类型的数据时，需要自定义行数据和类型的映射
    /**
     * 行元素映射
     */
    public class StudentRowMapper implements RowMapper<Student> {
        /**
         * 需要注意的是，resultSet并不是全部的查询结果集，而是查询中每一行的结果集。即框架会自动遍历结果集，将每一行的内容放入到resultSet中。
         * @param resultSet
         * @param i
         */
        @Override
        public Student mapRow(ResultSet resultSet, int i) throws SQLException {
            Student student = new Student(resultSet.getString("name"),
                    resultSet.getInt("age"),
                    resultSet.getDouble("score"));
            student.setId(resultSet.getInt("id"));
            return student;
        }
    }
    @Override
    public Student selectById(int id) {
        String sql = "select id, name, age, score from student where id = ?";
        Student student = this.getJdbcTemplate().queryForObject(sql, new StudentRowMapper(), id);
        return student;
    }
    // 查询指定字段数据，可以利用map做映射
    @Override
    public List<Map<String, Object>> selectOptional(){
        String sql = "select name, age from student";
        List<Map<String, Object>> result = this.getJdbcTemplate().query(sql, new RowMapper<Map<String, Object>>() {
            @Override
            public Map<String, Object> mapRow(ResultSet resultSet, int i) throws SQLException {
                Map<String, Object> map = new HashMap<>();
                map.put("name", resultSet.getString("name"));
                map.put("age", resultSet.getInt("age"));
                return map;
            }
        });

        return result;
    }
