INSERT INTO public.users (id,email,"password") VALUES
	 ('7df9098b-9960-4644-a513-1f490e0ebdbb','lchown0@mail.ru','$2a$06$4i3gwm6Pmxw953mel5EM5OCCLbDmHIAjjW6OGygG6IkLTkGxVOY6C'),
	 ('e687035b-b9d7-421e-aa85-3fd4dc2fdb0e','rpavolini1@smugmug.com','$2a$06$q2iXuYERI/YtfngZsUIqeOi9KXSTCQwydaXs003mIM4onD3rBNTSO'),
	 ('144abba9-4a64-4dfa-a8c4-6f6a20d16248','rstoodley2@elpais.com','$2a$06$KYwTpwS3hM6ejah.01JEiOdR3UVev/tD5/QjbQkLX6si.wp9oGizO'),
	 ('309762fe-235f-4528-aad5-dede82c40f5d','sfridd3@ehow.com','$2a$06$2XTnNsy3YrirvvBN.WoNb.FBEK/QAPhgyn1hRsSG2tXiV43OxA/z6'),
	 ('5122b9c1-2d1e-4f48-8a1e-b358f10daade','klindwall4@abc.net.au','$2a$06$VxZ6mt86qQ4u5T0QjZo.Z.4j/w9am8ipJMY4oj0fduTEj22ehPGFC'),
	 ('551e9fde-03ac-4033-a833-7718f3ad026c','nabeles5@myspace.com','$2a$06$QttLki3nfDxvTFsbzL6azOZFR8468ZYBHiNv9Hs/LFKHjeQMrwUdm'),
	 ('15374a83-50a2-4d45-9b73-171657edf6de','bschoffler6@ucsd.edu','$2a$06$7QbYPZbLoafDXCmjJESCguJzg7ew5TeGfzfau63pEsrjJNT8Ta0UK'),
	 ('4db6542e-be66-461a-ac0a-57eafe4f3caa','rgratrex7@altervista.org','$2a$06$ySZSVMYpNm4Av5nGTk1OsemR2JuHmvFZ3VKkLxN6pJb/T3g9Dv8Ae'),
	 ('e96bdb09-4005-418b-97fe-fafaae8678cd','tcerith8@java.com','$2a$06$VpGxgjp4n3.DUWY2lIDxz.UTYFV6sHXur2D6/Bm7KqadiqNgd7a3u'),
	 ('86bf0424-e4f9-4be7-958d-8269154eb008','jkesteven9@blogtalkradio.com','$2a$06$jskmCnKbukgOiJx0jpwnHuXKuN2ePaDNrN9eTA2iG1iuHDl74hoOG');

INSERT INTO public.questions (id,question) VALUES
	 ('b12fd286-41e1-42fc-86be-ee5c8f470679','Whats your companys size?'),
	 ('af2ba800-521a-40c8-870a-c74f343ee1e3','What''s your company''s size?'),
	 ('13c4f257-0a7e-4d5e-94dc-d2dacfc75663','What''s your annual gross revenue?'),
	 ('22723d32-a0f0-4c64-a07a-79d0f5d3f75c','What''s the annual volume of transactions your company produces?'),
	 ('a600edaa-e6d1-43a3-b820-a7b5635e928f','Do you agree with the following sentence? My company uses unified IT services across its whole infrastructure.');

INSERT INTO public.answers (id,question_id,answer) VALUES
	 ('94d75918-cde4-4cba-8784-67b1918ba14e','af2ba800-521a-40c8-870a-c74f343ee1e3','0-10'),
	 ('253d23f2-ff76-4ab1-9c12-d3cbd96f2690','af2ba800-521a-40c8-870a-c74f343ee1e3','10-100'),
	 ('7d07bb13-62bb-4e80-b02e-37b0d8eb5900','af2ba800-521a-40c8-870a-c74f343ee1e3','>100'),
	 ('147524f8-ef23-4b1f-894c-bd8be1f1e6c2','13c4f257-0a7e-4d5e-94dc-d2dacfc75663','10,000-100,000'),
	 ('2fd59a7c-bd6f-4428-8c45-1bccf9487d3f','13c4f257-0a7e-4d5e-94dc-d2dacfc75663','100,000-500,000'),
	 ('04a27d4e-87ac-4929-aaa9-d1b63f0e3977','13c4f257-0a7e-4d5e-94dc-d2dacfc75663','500,000-1,000,000'),
	 ('418a08bf-45d2-40d8-b5d6-d3133c9806bb','22723d32-a0f0-4c64-a07a-79d0f5d3f75c','1,000-5,000'),
	 ('26371720-f2b5-4b33-b5ff-1d90f936e0b1','22723d32-a0f0-4c64-a07a-79d0f5d3f75c','5,000-10,000'),
	 ('f96420c1-5968-4e61-bc08-4ec2378340d9','22723d32-a0f0-4c64-a07a-79d0f5d3f75c','>10,000'),
	 ('3f2c7170-e93e-4d12-a6c4-853958544346','a600edaa-e6d1-43a3-b820-a7b5635e928f','Very much');
INSERT INTO public.answers (id,question_id,answer) VALUES
	 ('a74f04a7-103f-46f5-814a-afdd47316b66','a600edaa-e6d1-43a3-b820-a7b5635e928f','Somewhat unified'),
	 ('e7eba66b-c1f9-4954-a9b7-1e1b1009e0f1','a600edaa-e6d1-43a3-b820-a7b5635e928f','Disagree'),
	 ('08357770-ad44-48a0-a0cf-ea3916eb5749','a600edaa-e6d1-43a3-b820-a7b5635e928f','Completely disagree');
