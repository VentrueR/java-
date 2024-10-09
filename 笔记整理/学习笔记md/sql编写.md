## 简单查询

1. 考虑null

2. distinct

3. length()

4. count()等聚合函数 和 group  by一起用

5. datediff

6. round(x,3)保留小数

7. ```
   SUM(IF(activity_type = 'start', -timestamp, timestamp))
   ```

8. ```
   SUM(
               CASE
                   WHEN activity_type = 'start' THEN -timestamp
                   ELSE timestamp
               END
           )
   ```

9. ```sql
   mod(id, 2) = 1
   ```

10. ```sql
    DATE_FORMAT(trans_date, '%Y-%m') AS month
    
    COUNT(IF(state = 'approved', 1, NULL)) AS approved_count,
    ```

11. 