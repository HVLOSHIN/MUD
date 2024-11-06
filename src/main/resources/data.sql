INSERT INTO TEXTRPG.equipment (description, name, slot) VALUES
('휘두르면 부러질 것 같다.', '나무 단검', 'ONE_HANDED_WEAPON');

INSERT INTO TEXTRPG.equipment_effect (value, equipment_id, effect_type) VALUES
(1.8, 1, 'PA'),
(0.9, 1, 'AR');

INSERT INTO TEXTRPG.passive_skill (mastery, requiredap, skill_level, job_id, next_skill_id,  description, name) VALUES
(200, 2, 1, 1, 2, '인내는 위기상황을 돌파하는데 좋은 무기가 될것이다.', '인내증강I'),
(1100, 2, 2, 1, 3,  '인내는 위기상황을 돌파하는데 좋은 무기가 될것이다.', '인내증강II'),
(4500, 2, 3, 1, 4,  '인내는 위기상황을 돌파하는데 좋은 무기가 될것이다.', '인내증강III'),
(22000, 2, 4, 1, 5,  '인내는 위기상황을 돌파하는데 좋은 무기가 될것이다.', '인내증강IV'),
(110000, 2, 5, 1, 6,  '인내는 위기상황을 돌파하는데 좋은 무기가 될것이다.', '인내증강V'),
(220000, 2, 6, 1, 7,  '인내의 끝에는 무엇이 기다리는가?', '인내증강VI');

INSERT INTO TEXTRPG.passive_skill_effect (value, skill_id, effect_type, operation) VALUES
(2, 1, 'HP', 'MULTI_OPERATION'),
(4, 2, 'HP', 'MULTI_OPERATION'),
(6, 3, 'HP', 'MULTI_OPERATION'),
(8, 4, 'HP', 'MULTI_OPERATION'),
(10, 5, 'HP', 'MULTI_OPERATION'),
(12, 6, 'HP', 'MULTI_OPERATION');

INSERT INTO TEXTRPG.active_skill (chance, mastery, priority, requiredap, skill_level, job_id, next_skill_id,  description, name, type) VALUES
(20, 100, 1, 2, 1, 1, null, '상대를 강하게 타격한다. 물리공격력*1.5', '강타', 'SPECIAL_ATTACK');


INSERT INTO TEXTRPG.active_skill_effect (value, skill_id, effect_type, operation) VALUES
(1.5, 1, 'PA', 'MULTI_OPERATION');

INSERT INTO TEXTRPG.job (mastery, required_dex, required_int, required_str, description, name) VALUES
(300, 0, 0, 0, '여행을 막 떠난, 떠나려 하는 별다른 특징이 없는 직업.', '여행자');

INSERT INTO TEXTRPG.job_effect (value, job_id, effect_type, operation) VALUES
(5, 1, 'HP', 'SUM_OPERATION');


INSERT INTO TEXTRPG.field (min_level, description, name, type, next_field_id) VALUES
(0, '마을 안에 위치한 수련장. 죽을일 없다.', '수련장', 'NORMAL',2),
(24, '마을 근교의 낮은 야산', '야산', 'NORMAL',3),
(64, '야산 깊은 곳의, 고블린들이 이룬 부락', '고블린 부락', 'NORMAL',4);

INSERT INTO TEXTRPG.enemy (ar, av, cd, ct, dexterity, givehp, hp, intelligence, ma, md, pa, pd, strength, field_id, description, name, enemy_type) VALUES
(30001, 0, 150, 0, 0, 1, 50, 0, 0, 1, 0, 1, 0, 1, '나무로 만들어진 수련용 인형이다.수련의 의미가 있을는지 의문이 들 정도로 연약한 강도를 지녔다.그러나 누구에게나 처음은 있는 법.', '나무 인형', 'NORMAL'),
(30001, 0, 150, 0, 0, 2, 400, 0, 0, 5, 0, 5, 0, 1, '청동으로 만들어진 수련용 인형이다.좀 더 단단해지긴 했지만 조금 두드리다 보면 박살 나는 건 여전하다.', '청동 인형', 'NORMAL'),
(30001, 0, 150, 0, 0, 8, 2000, 0, 0, 10, 0, 10, 0, 1, '철로 만들어진 수련용 인형이다.제법 단단해졌고, 자가 수복 기능이 추가되었다.수리비가 좀 부담스러운 것 같다.', '철제 인형', 'NORMAL');

INSERT INTO TEXTRPG.item (description, drop_rate, enemy_id, name, price) VALUES
('나무 인형의 파편. 어딘가엔 요긴하게 쓰이지 않을까?', 20, 1, '나무 쪼가리', 2);

