1) 175. Combine Two Tables
    ```mysql
   select FirstName, LastName, City, State
   from Person left join Address
   on Person.PersonId = Address.PersonId;
    ```
   
2) 176. Second Highest Salary
   ```mysql
   # 思路1
   select max(Salary) SecondHighestSalary
   from Employee
   where
   Salary<(select max(Salary) from Employee);
   
   # 速度很慢, ifNull()函数可防止第二结果为空
   select ifNull(
   (select distinct salary
   from Employee
   order by Salary Desc
   limit 1,1),null
   ) as SecondHighestSalary;
   # 速度较快, 没有用ifNull
   select(
    select distinct Salary 
    from Employee
    order by Salary desc
    limit 1 offset 1
   ) as SecondHighestSalary;

   ```
第二高的查询思路，利用本题的解决办法可以解决这类问题：查询第N高的数据
- limit字句的用法
- ifnull的用法
```mysql
# 思路1
select max(distinct 成绩) 
from 成绩表
where 课程='语文' and
      成绩 < (select max(distinct 成绩) 
              from 成绩表 
              where 课程='语文');
# 思路2
select distinct 成绩
from 成绩表
where 课程='语文'
order by 课程,成绩 desc
limit 1,1;
```
