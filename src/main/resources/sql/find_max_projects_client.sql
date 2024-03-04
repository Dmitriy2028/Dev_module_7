SELECT c.name AS client_name, COUNT(p.id) AS project_count
FROM client c
JOIN project p ON c.id = p.client_id
GROUP BY c.name
HAVING COUNT(p.id) = (
    SELECT COUNT(id)
    FROM project
    GROUP BY client_id
    ORDER BY COUNT(id) DESC
    LIMIT 1
);