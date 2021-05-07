1) 175 Combine Two Tables
    ```mysql
   select FirstName, LastName, City, State
   from Person left join Address
   on Person.PersonId = Address.PersonId;
    ```
   
2) 176 Second Highest Salary
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
3) 177 Nth Highest Salary
   ```mysql
   CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
   BEGIN
   # limit 后不能做运算代码
      declare M int;
      set M = N - 1;
      RETURN (
      # Write your MySQL query statement below.
      select(
         select distinct Salary
         from Employee
         order by Salary desc
         limit 1 offset M
      )  
      );
   END
   ```
4) 178 Rank Scores  
   使用窗口函数
   - `rank()` : 排名有间隔
   - `dense_rank()`：无间隔
   - `row_number()`：按照简单自然排序
   ```mysql
   # Write your MySQL query statement below
   SELECT
      Score,
      DENSE_RANK() over w as 'Rank'
   FROM Scores
   WINDOW w AS (order by Score desc);
   
   # 或者
   SELECT
      Score ,
      dense_rank() over (order by Score desc)  as 'Rank'
   FROM Scores;
   # 不指定 partition by 相当于所有行数据一个 partition, 数据进行区内排序
   # dense_rank() 相当于每一行数据一个窗口, 对数据进行比较
   ```