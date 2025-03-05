SELECT employee_id, 
       department_id
FROM (
    SELECT employee_id, 
           department_id, 
           primary_flag,
           COUNT(department_id) OVER (PARTITION BY employee_id) AS department_count
    FROM Employee
) AS subquery
WHERE (primary_flag = 'Y' OR department_count = 1);
