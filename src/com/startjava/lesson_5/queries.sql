-- queries SQL all
SELECT * FROM jaegers;
-- SQL remove all worker
SELECT * FROM jaegers WHERE status = 'Worker';
-- SQL remove all Mark-1 and Mark-4
SELECT * FROM jaegers WHERE mark IN ('Mark-1', 'Mark-4'); 
-- SQL remove all but Mark-1 and Mark-4
SELECT * FROM jaegers WHERE NOT mark = 'Mark-1' AND NOT mark = 'Mark-4'; 
-- SQL Sort descending column mark
SELECT * FROM jaegers ORDER BY mark DESC;
-- SQL The oldest robot
SELECT * FROM jaegers WHERE launch = (SELECT MIN(launch) FROM jaegers); 
-- SQL the robot destroyed the most kaiju
SELECT * FROM jaegers WHERE kaijukill = (SELECT MAX(kaijukill) FROM jaegers);
-- SQL average weight of robots
SELECT AVG(weight) FROM jaegers;
-- SQL remove all worker and update set increment
SELECT * FROM jaegers WHERE status = 'Worker';
UPDATE jaegers SET kaijukill = (kaijukill + 1) WHERE status = 'Worker';
SELECT * FROM jaegers WHERE status = 'Worker';
-- SQL remove all delete desroyed
DELETE FROM jaegers WHERE status = 'Destroyed';