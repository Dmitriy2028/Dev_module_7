WITH oldest AS (
    SELECT 'OLDEST' AS TYPE,
           NAME,
           birthday
    FROM worker
    WHERE birthday = (SELECT MIN(birthday) FROM worker)
),
youngest AS (
    SELECT 'YOUNGEST' AS TYPE,
           NAME,
           birthday
    FROM worker
    WHERE birthday = (SELECT MAX(birthday) FROM worker)
)
SELECT *
FROM youngest
UNION ALL
SELECT *
FROM oldest;