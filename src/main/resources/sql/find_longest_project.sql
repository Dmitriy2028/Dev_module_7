SELECT p.id, TIMESTAMPDIFF(MONTH, p.start_date, p.finish_date) as month_count
FROM project p
GROUP BY p.id
HAVING month_count = (
    SELECT TIMESTAMPDIFF(MONTH, p2.start_date, p2.finish_date) as month_count2
    FROM project p2
    ORDER BY month_count2 DESC
    LIMIT 1
);