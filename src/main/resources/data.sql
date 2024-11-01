INSERT INTO TEXTRPG.equipment (description, name, slot) VALUES
('휘두르면 부러질 것 같다.', '나무 단검', 'ONE_HANDED_WEAPON');

INSERT INTO TEXTRPG.equipment_effect (value, equipment_id, effect_type) VALUES
(1.8, 1, 'PA'),
(0.9, 1, 'AR');

INSERT INTO TEXTRPG.users (created_at, updated_at, login_id, username, password, role) VALUES
('2024-10-31 18:09:57', '2024-10-31 18:10:00', 'test', 'test', 'test', 'ADMIN');

INSERT INTO TEXTRPG.user_stats (ap, current_action_points, dexterity, gold, hp, intelligence, level, max_action_points, strength, user_id) VALUES
(5, 100, 10, 0, 10, 10, 1, 100, 10, 1);

INSERT INTO TEXTRPG.user_achievements (kill_count, max_damage, used_hp, total_damage, total_gold, used_gold, user_id) VALUES
(0, 0, 0, 0, 0, 0, 1);

INSERT INTO TEXTRPG.user_equipment (is_equipped, equipment_id, user_id, grade) VALUES
(true, 1, 1, 'RARE');

INSERT INTO TEXTRPG.passive_skill (mastery, requiredap, skill_level, job_id, next_skill_id, prev_skill_id, description, name) VALUES
(200, 2, 1, 1, 2, null, '인내는 위기상황을 돌파하는데 좋은 무기가 될것이다.', '인내증강I'),
(1100, 2, 2, 1, 3, 1, '인내는 위기상황을 돌파하는데 좋은 무기가 될것이다.', '인내증강II'),
(4500, 2, 3, 1, 4, 2, '인내는 위기상황을 돌파하는데 좋은 무기가 될것이다.', '인내증강III'),
(22000, 2, 4, 1, 5, 3, '인내는 위기상황을 돌파하는데 좋은 무기가 될것이다.', '인내증강IV'),
(110000, 2, 5, 1, 6, 4, '인내는 위기상황을 돌파하는데 좋은 무기가 될것이다.', '인내증강V'),
(220000, 2, 6, 1, 7, 5, '인내의 끝에는 무엇이 기다리는가?', '인내증강VI');

INSERT INTO TEXTRPG.passive_skill_effect (value, skill_id, effect_type, operation) VALUES
(2, 1, 'HP', 'MULTI_OPERATION'),
(4, 2, 'HP', 'MULTI_OPERATION'),
(6, 3, 'HP', 'MULTI_OPERATION'),
(8, 4, 'HP', 'MULTI_OPERATION'),
(10, 5, 'HP', 'MULTI_OPERATION'),
(12, 6, 'HP', 'MULTI_OPERATION');

INSERT INTO TEXTRPG.active_skill (chance, mastery, priority, requiredap, skill_level, job_id, next_skill_id, prev_skill_id, description, name, type) VALUES
(20, 100, 1, 2, 1, 1, null, null, '상대를 강하게 타격한다. 물리공격력*1.5', '강타', 'SPECIAL_ATTACK');


INSERT INTO TEXTRPG.active_skill_effect (value, skill_id, effect_type, operation) VALUES
(1.5, 1, 'PA', 'MULTI_OPERATION');

INSERT INTO TEXTRPG.job (mastery, required_dex, required_int, required_str, description, name) VALUES
(300, 0, 0, 0, '여행을 막 떠난, 떠나려 하는 별다른 특징이 없는 직업.', '여행자');

INSERT INTO TEXTRPG.job_effect (value, job_id, effect_type, operation) VALUES
(5, 1, 'HP', 'SUM_OPERATION');

INSERT INTO TEXTRPG.user_mastery (active_skill_masteryexp, job_masteryexp, passive_skill_masteryexp, active_skill_id, job_id, passive_skill_id, user_id, status) VALUES
(0, 0, 0, null, 1, null, 1, 'NOT_STARTED');