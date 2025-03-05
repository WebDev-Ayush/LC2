SELECT 
    ROUND(
        COUNT(DISTINCT CASE WHEN a2.event_date IS NOT NULL THEN a1.player_id END) * 1.0 / COUNT(DISTINCT a1.player_id),
        2
    ) AS fraction
FROM Activity a1
LEFT JOIN Activity a2
ON a1.player_id = a2.player_id
AND a2.event_date = DATE_ADD(a1.event_date, INTERVAL 1 DAY)
WHERE a1.event_date = (
    SELECT MIN(event_date)
    FROM Activity
    WHERE player_id = a1.player_id
);