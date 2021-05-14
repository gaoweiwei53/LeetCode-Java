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
   
5) 180 Consecutive Numbers
   ```mysql
   SELECT DISTINCT Num ConsecutiveNums
   FROM(
      SELECT *,
      ROW_NUMBER() OVER (PARTITION BY Num ORDER BY Id) rownum
      FROM LOGS
   ) t
   GROUP BY (Id+1-rownum),Num
   HAVING COUNT(*)>=3
   ```

6) 181 Employees Earning More Than Their Managers  
   使用自连接
   ```mysql
   select 
    e1.name as Employee
   from
   employee as e1,employee as e2
   where
   e1.managerId = e2.Id and e1.salary > e2.salary
   ```
7) 182. Duplicate Emails
   ```mysql
   #  方法1
   select Email from
    (select Email, count(Email) as num
     from Person
     group by Email
    ) as statistic
   where num > 1;
   
   # 方法为2
   select Email
   from Person
   group by Email
   having count(Email) > 1;

   ```
   
8) 183. Customers Who Never Order
   ```mysql
   # 方法1
   SELECT Name as Customers
   FROM Customers left join Orders
   on Customers.Id = Orders.CustomerId
   Where CustomerId is Null;
    
   # 方法2
   select customers.name as 'Customers'
   from customers
   where customers.id not in
   (
   select customerid from orders
   );
   ```