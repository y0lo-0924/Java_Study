## 注解说明
- @Autowired:自动装配通过类型,名字。
  
    如果Autowired不能自动装配上属性，则需要通过@Qualifier(value="xxx")
- @Nullable:字段装配通过名字，类型。
- @Resource:自动装配通过名字，类型。
  

- @Component:组件，放在类上，说明这个类被Spring管理了，就是bean！
