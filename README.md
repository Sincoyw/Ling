# 项目名：Ling
## 简介
一个从零开始的服务器项目，一步一步，实现完全的不依赖Xml配置，而使用Java的Notation方式。第一阶段先完成用户注册和登录的功能。
## 项目说明
1. 使用条件化的Bean来完成对数据库的使用，关于不同环境下的profile定义如下：
    * 开发环境：dev
    * 测试环境：alpha
    * 预发布环境：beta
    * 正式环境：release
2. 放弃使用embededDataSource,因为使用h2的数据库语法和Mysql语法有差异。
3. 正式环境下的JNDI要使用的Datasource要在Tomcat或着什么别的容器里进行配置，不然会找不到。
## 项目实现过程
1. 实现与数据库的对接，使用Hebenet。
2. 实现Thymeleaf与服务器的数据表单白提交。
3. 实现注册功能。
4. TODO：实现只请求数据不请求页面。@ResponseBody
5. TODO：实现一个按钮请求其它数据，动态更新页面。
6. TODO：数据库表索引。