
delete from user_profile;
delete from visit;
delete from menu_item;
delete from menu;
delete from module;
delete from admin_user;
delete from property;
delete from chat_properties;


----------------------------------
--chat_properties
INSERT INTO chat_properties(id, version, chat_icon, chat_type) VALUES (1, 1, 1, 1);

----------------------------------
--property
INSERT INTO property(
id,  version,  active_date,  chain,  hotel_name,  inactive_date,  lat_lng,  location,  status,  sub_chain,  property_image,  propertybgcolor, 
            address1, address2, city, country, phone_number, postal_code, state, email, fax_number, reservations_number)
    VALUES (1, 1, null,null,'Hyatt Cancun Resort', null,null,'Cancun', 'ACTIVE', null,'logo_brand_HYATT.png', '#ffffff',
    'Blvd. Kukulcan km 8.5',null,'Cancun','Mexico','+52 998 891 5555','77500','Quintana Roo','cancun.regency@hyatt.com','+52 998 883 1349','1-888-591-1234' 
    );

INSERT INTO property(
id,  version,  active_date,  chain,  hotel_name,  inactive_date,  lat_lng,  location,  status,  sub_chain,  property_image,  propertybgcolor, 
            address1, address2, city, country, phone_number, postal_code, state, email, fax_number, reservations_number)
    VALUES (2, 1, null,null,'Marriott Wailea Resort', null,null,'Maui', 'ACTIVE', null,'logo_brand_MARRIOTT_Wailea.gif', '#ffffff',
     '3700 Wailea Alanui',null,'Wailea','USA','1-808-879-1922','96753','Hawaii','wailea@marriott.com', '1-808-874-7888','1-888-236-2427'
     );

INSERT INTO property(
id,  version,  active_date,  chain,  hotel_name,  inactive_date,  lat_lng,  location,  status,  sub_chain,  property_image,  propertybgcolor, 
            address1, address2, city, country, phone_number, postal_code, state, email, fax_number, reservations_number)
    VALUES (3, 1, null,null,'Chicago Hilton', null,null,'Chicago', 'ACTIVE', null,'logo_brand_HILTON.png', '#ffffff',
    '720 South Michigan Avenue',null,'Chicago','USA','1-312-922-4400','60605','Illinois','chich_salesadm@hilton.com','1-312-922-5240','1-800-HILTON'
    );

INSERT INTO property(
id,  version,  active_date,  chain,  hotel_name,  inactive_date,  lat_lng,  location,  status,  sub_chain,  property_image,  propertybgcolor, 
            address1, address2, city, country, phone_number, postal_code, state, email, fax_number, reservations_number)
    VALUES (4, 1, null,null,'Lake Tahoe Ritz Residences', null,null,'Lake Tahoe', 'ACTIVE', null,'logo_brand_RITZ.jpg', '#ffffff',
    '13031 Ritz-Carlton Highlands Court',null,'Truckee','USA','1-530-562-3000','96161','California','contact@ritz.com','1-503-562-3000','1-800-542-8680'
    );


----------------------------------
--module
--property 1

INSERT INTO module(id, version, action, caption,controller,description,image_src, active_date, chat_enabled, device_id, device_type,email_enabled, inactive_date, property_id, sms_enabled, status, type, name,message,display_order)    VALUES ( 
1,1,'index','Room Service@','roomService','Room Service','/assets/img/fpo_roomservice.png',current_timestamp,'Y',null,null,'N',null,1,'N','ACTIVE',null,'Room Service','Can you please help me?',1);
INSERT INTO module(id, version, action, caption,controller,description,image_src, active_date, chat_enabled, device_id, device_type,email_enabled, inactive_date, property_id, sms_enabled, status, type, name, message,display_order)    VALUES (  
2,1,'index','Concierge@','chatExisting','Concierge','/assets/img/concierge.png',current_timestamp,'Y',null,null,'N',null,1,'N','ACTIVE',null,'Concierge','Can you please help me?',2);
INSERT INTO module(id, version, action, caption,controller,description,image_src, active_date, chat_enabled, device_id, device_type,email_enabled, inactive_date, property_id, sms_enabled, status, type, name, message,display_order)    VALUES (  
3,1,'index','Conference@','conference','Conference','/assets/img/conference_1.png',current_timestamp,'Y',null,null,'N',null,1,'N','ACTIVE',null,'Conference','What room is the show in',3);
INSERT INTO module(id, version, action, caption,controller,description,image_src, active_date, chat_enabled, device_id, device_type,email_enabled, inactive_date, property_id, sms_enabled, status, type, name, message,display_order)    VALUES (  
4,1,'index','Restaurant@','restaurant','Restaurant','/assets/img/restaurant.png',current_timestamp,'Y',null,null,'N',null,1,'N','ACTIVE',null,'Restaurant','Can you please help me?',4);
INSERT INTO module(id, version, action, caption,controller,description,image_src, active_date, chat_enabled, device_id, device_type,email_enabled, inactive_date, property_id, sms_enabled, status, type, name, message,display_order)    VALUES (  
5,1,'index','Wireless Service@','wireless','Wireless Service','/assets/img/wifi_service.png',current_timestamp,'Y',null,null,'N',null,1,'N','ACTIVE',null,'Wireless Service','Can you please help me?',5);
INSERT INTO module(id, version, action, caption,controller,description,image_src, active_date, chat_enabled, device_id, device_type,email_enabled, inactive_date, property_id, sms_enabled, status, type, name,message,display_order)    VALUES ( 
6,1,'index','Courier Service@','courier','Courier Service','/assets/img/courier.png',current_timestamp,'Y',null,null,'N',null,1,'N','ACTIVE',null,'Courier Service','Can you please help me?',6);
INSERT INTO module(id, version, action, caption,controller,description,image_src, active_date, chat_enabled, device_id, device_type,email_enabled, inactive_date, property_id, sms_enabled, status, type, name, message,display_order)    VALUES (  
7,1,'index','Concierge@','chatExisting','Concierge','/assets/img/concierge.png',current_timestamp,'Y',null,null,'N',null,1,'N','ACTIVE',null,'Concierge','Can you please help me?',7);
INSERT INTO module(id, version, action, caption,controller,description,image_src, active_date, chat_enabled, device_id, device_type,email_enabled, inactive_date, property_id, sms_enabled, status, type, name, message,display_order)    VALUES (  
8,1,'index','Golf Drink Cart@','golfDrinkCart','GolfDrinkCart','/assets/img/beverages.png',current_timestamp,'Y',null,null,'N',null,1,'N','ACTIVE',null,'Golf Drink Cart','I would like a drink at the 9th hole',8);
--property 2
INSERT INTO module(id, version, action, caption,controller,description,image_src, active_date, chat_enabled, device_id, device_type,email_enabled, inactive_date, property_id, sms_enabled, status, type, name,message,display_order)    VALUES ( 
9,1,'index','Room Service@','roomService','Room Service','/assets/img/fpo_roomservice.png',current_timestamp,'Y',null,null,'N',null,2,'N','ACTIVE',null,'Room Service','Can you please help me?',1);
INSERT INTO module(id, version, action, caption,controller,description,image_src, active_date, chat_enabled, device_id, device_type,email_enabled, inactive_date, property_id, sms_enabled, status, type, name, message,display_order)    VALUES (  
10,1,'index','Wireless Service@','wireless','Wireless Service','/assets/img/wifi_service.png',current_timestamp,'Y',null,null,'N',null,2,'N','ACTIVE',null,'Wireless Service','Can you please help me?',2);
INSERT INTO module(id, version, action, caption,controller,description,image_src, active_date, chat_enabled, device_id, device_type,email_enabled, inactive_date, property_id, sms_enabled, status, type, name, message,display_order)    VALUES (  
11,1,'index','Restaurant@','restaurant','Restaurant','/assets/img/restaurant.png',current_timestamp,'Y',null,null,'N',null,2,'N','INACTIVE',null,'Restaurant','Can you please help me?',3);
INSERT INTO module(id, version, action, caption,controller,description,image_src, active_date, chat_enabled, device_id, device_type,email_enabled, inactive_date, property_id, sms_enabled, status, type, name, message,display_order)    VALUES (  
12,1,'index','Concierge@','chatExisting','Concierge','/assets/img/concierge.png',current_timestamp,'Y',null,null,'N',null,2,'N','ACTIVE',null,'Concierge','Can you please help me?',4);
INSERT INTO module(id, version, action, caption,controller,description,image_src, active_date, chat_enabled, device_id, device_type,email_enabled, inactive_date, property_id, sms_enabled, status, type, name, message,display_order)    VALUES (  
13,1,'index','Golf Drink Cart@','golfDrinkCart','GolfDrinkCart','/assets/img/beverages.png',current_timestamp,'Y',null,null,'N',null,2,'N','ACTIVE',null,'Golf Drink Cart','I would like a drink at the 9th hole',5);
INSERT INTO module(id, version, action, caption,controller,description,image_src, active_date, chat_enabled, device_id, device_type,email_enabled, inactive_date, property_id, sms_enabled, status, type, name, message,display_order)    VALUES (  
14,1,'index','Conference@','conference','Conference','/assets/img/conference_1.png',current_timestamp,'Y',null,null,'N',null,2,'N','ACTIVE',null,'Conference','What room is the show in',6);
--property 3
INSERT INTO module(id, version, action, caption,controller,description,image_src, active_date, chat_enabled, device_id, device_type,email_enabled, inactive_date, property_id, sms_enabled, status, type, name,message,display_order)    VALUES ( 
15,1,'index','Room Service@','roomService','Room Service','/assets/img/fpo_roomservice.png',current_timestamp,'Y',null,null,'N',null,3,'N','ACTIVE',null,'Room Service','Can you please help me?',1);
INSERT INTO module(id, version, action, caption,controller,description,image_src, active_date, chat_enabled, device_id, device_type,email_enabled, inactive_date, property_id, sms_enabled, status, type, name, message,display_order)    VALUES (  
16,1,'index','Concierge@','chatExisting','Concierge','/assets/img/concierge.png',current_timestamp,'Y',null,null,'N',null,3,'N','ACTIVE',null,'Concierge','Can you please help me?',2);
INSERT INTO module(id, version, action, caption,controller,description,image_src, active_date, chat_enabled, device_id, device_type,email_enabled, inactive_date, property_id, sms_enabled, status, type, name, message,display_order)    VALUES (  
17,1,'index','Golf Drink Cart@','golfDrinkCart','GolfDrinkCart','/assets/img/beverages.png',current_timestamp,'Y',null,null,'N',null,3,'N','ACTIVE',null,'Golf Drink Cart','I would like a drink at the 9th hole',3);
INSERT INTO module(id, version, action, caption,controller,description,image_src, active_date, chat_enabled, device_id, device_type,email_enabled, inactive_date, property_id, sms_enabled, status, type, name, message,display_order)    VALUES (  
18,1,'index','Restaurant@','restaurant','Restaurant','/assets/img/restaurant.png',current_timestamp,'Y',null,null,'N',null,3,'N','ACTIVE',null,'Restaurant','Can you please help me?',4);
INSERT INTO module(id, version, action, caption,controller,description,image_src, active_date, chat_enabled, device_id, device_type,email_enabled, inactive_date, property_id, sms_enabled, status, type, name, message,display_order)    VALUES (  
19,1,'index','Wireless Service@','wireless','Wireless Service','/assets/img/wifi_service.png',current_timestamp,'Y',null,null,'N',null,3,'N','ACTIVE',null,'Wireless Service','Can you please help me?',5);
--property 4
INSERT INTO module(id, version, action, caption,controller,description,image_src, active_date, chat_enabled, device_id, device_type,email_enabled, inactive_date, property_id, sms_enabled, status, type, name,message,display_order)    VALUES ( 
20,1,'index','Room Service@','roomService','Room Service','/assets/img/fpo_roomservice.png',current_timestamp,'Y',null,null,'N',null,4,'N','ACTIVE',null,'Room Service','Can you please help me?',1);
INSERT INTO module(id, version, action, caption,controller,description,image_src, active_date, chat_enabled, device_id, device_type,email_enabled, inactive_date, property_id, sms_enabled, status, type, name, message,display_order)    VALUES (  
21,1,'index','Concierge@','chatExisting','Concierge','/assets/img/concierge.png',current_timestamp,'Y',null,null,'N',null,4,'N','ACTIVE',null,'Concierge','Can you please help me?',2);
INSERT INTO module(id, version, action, caption,controller,description,image_src, active_date, chat_enabled, device_id, device_type,email_enabled, inactive_date, property_id, sms_enabled, status, type, name, message,display_order)    VALUES (  
22,1,'index','Golf Drink Cart@','golfDrinkCart','GolfDrinkCart','/assets/img/beverages.png',current_timestamp,'Y',null,null,'N',null,4,'N','ACTIVE',null,'Golf Drink Cart','I would like a drink at the 9th hole',3);
INSERT INTO module(id, version, action, caption,controller,description,image_src, active_date, chat_enabled, device_id, device_type,email_enabled, inactive_date, property_id, sms_enabled, status, type, name, message,display_order)    VALUES (  
23,1,'index','Restaurant@','restaurant','Restaurant','/assets/img/restaurant.png',current_timestamp,'Y',null,null,'N',null,4,'N','ACTIVE',null,'Restaurant','Can you please help me?',4);
INSERT INTO module(id, version, action, caption,controller,description,image_src, active_date, chat_enabled, device_id, device_type,email_enabled, inactive_date, property_id, sms_enabled, status, type, name, message,display_order)    VALUES (  
24,1,'index','Wireless Service@','wireless','Wireless Service','/assets/img/wifi_service.png',current_timestamp,'Y',null,null,'N',null,4,'N','ACTIVE',null,'Wireless Service','Can you please help me?',5);
INSERT INTO module(id, version, action, caption,controller,description,image_src, active_date, chat_enabled, device_id, device_type,email_enabled, inactive_date, property_id, sms_enabled, status, type, name, message,display_order)    VALUES (  
25,1,'index','Conference@','conference','Conference','/assets/img/conference_1.png',current_timestamp,'Y',null,null,'N',null,4,'N','ACTIVE',null,'Conference','What room is the show in',6);
INSERT INTO module(id, version, action, caption,controller,description,image_src, active_date, chat_enabled, device_id, device_type,email_enabled, inactive_date, property_id, sms_enabled, status, type, name, message,display_order)    VALUES (  
26,1,'index','Courier Service@','courier','Courier Service','/assets/img/courier.png',current_timestamp,'Y',null,null,'N',null,4,'N','ACTIVE',null,'Courier Service','Can you please help me?',7);


---------------------------------
--menu

insert into menu (id, version, name, caption, message, params, image_src, property_id, module_id) values (1,1,'Breakfast Menu','Hours 6:00am - 11:00am','Enjoy breakfast in bed',null,'../assets/img/fpo_roomservice.png',1,1);
insert into menu (id, version, name, caption, message, params, image_src, property_id, module_id) values (2,1,'Lunch Menu','Hours 11:00am - 4:00 pm','Enjoy lunch in your room',null,'../assets/img/fpo_roomservice.png',1,1);
insert into menu (id, version, name, caption, message, params, image_src, property_id, module_id) values (3,1,'Dinner Menu','Hours 4:00pm - 11:00pm','Enjoy breakfast in bed',null,'../assets/img/fpo_roomservice.png',1,1);
insert into menu (id, version, name, caption, message, params, image_src, property_id, module_id) values (4,1,'Late Night Menu','Available 24 Hours','Enjoy dinner in your room',null,'../assets/img/fpo_roomservice.png',1,1);
insert into menu (id, version, name, caption, message, params, image_src, property_id, module_id) values (5,1,'Breakfast Menu','Hours 6:00am - 11:00am','Enjoy breakfast in bed',null,'../assets/img/fpo_roomservice.png',2,9);
insert into menu (id, version, name, caption, message, params, image_src, property_id, module_id) values (6,1,'Lunch Menu','Hours 11:00am - 4:00 pm','Enjoy lunch in your room',null,'../assets/img/fpo_roomservice.png',2,9);
insert into menu (id, version, name, caption, message, params, image_src, property_id, module_id) values (7,1,'Dinner Menu','Hours 4:00pm - 11:00pm','Enjoy breakfast in bed',null,'../assets/img/fpo_roomservice.png',2,9);
insert into menu (id, version, name, caption, message, params, image_src, property_id, module_id) values (8,1,'Late Night Menu','Available 24 Hours','Enjoy a snack anytime',null,'../assets/img/fpo_roomservice.png',2,9);
insert into menu (id, version, name, caption, message, params, image_src, property_id, module_id) values (9,1,'Breakfast Menu','Hours 6:00am - 11:00am','Enjoy breakfast in bed',null,'../assets/img/fpo_roomservice.png',3,15);
insert into menu (id, version, name, caption, message, params, image_src, property_id, module_id) values (10,1,'Lunch Menu','Hours 11:00am - 4:00 pm','Enjoy unch in your room',null,'../assets/img/fpo_roomservice.png',3,15);
insert into menu (id, version, name, caption, message, params, image_src, property_id, module_id) values (11,1,'Dinner Menu','Hours 4:00pm - 11:00pm','Enjoy dinner in your room',null,'../assets/img/fpo_roomservice.png',3,15);
insert into menu (id, version, name, caption, message, params, image_src, property_id, module_id) values (12,1,'Breakfast Menu','Hours 6:00am - 11:00am','Enjoy breakfast in bed',null,'../assets/img/fpo_roomservice.png',4,20);
insert into menu (id, version, name, caption, message, params, image_src, property_id, module_id) values (13,1,'Lunch Menu','Hours 11:00am - 4:00 pm','Enjoy unch in your room',null,'../assets/img/fpo_roomservice.png',4,20);
insert into menu (id, version, name, caption, message, params, image_src, property_id, module_id) values (14,1,'Dinner Menu','Hours 4:00pm - 11:00pm','Enjoy dinner in your room',null,'../assets/img/fpo_roomservice.png',4,20);

---------------------------------
--menu_item
--property 1
insert into menu_item (id, version, name, caption, message, params, controller, action, image_src, price, menu_type, menu_id) values (1,1,'Waffles','Served with syrup and your choice of fruit ',null,null,'roomService','menuItemInfo','../assets/img/fpo_roomservice.png','$9.99','food',1);
insert into menu_item (id, version, name, caption, message, params, controller, action, image_src, price, menu_type, menu_id) values (2,1,'Eggs Benedict','Traditional style',null,null,'roomService','menuItemInfo','../assets/img/fpo_roomservice.png','$13.99','food',1);
insert into menu_item (id, version, name, caption, message, params, controller, action, image_src, price, menu_type, menu_id) values (3,1,'Coffee','French Roast',null,null,'roomService','menuItemInfo','../assets/img/fpo_roomservice.png','$3.99','drink',1);
insert into menu_item (id, version, name, caption, message, params, controller, action, image_src, price, menu_type, menu_id) values (4,1,'Hot Oatmeal','With your choice of toppings',null,null,'roomService','menuItemInfo','../assets/img/fpo_roomservice.png','$6.99','food',1);
insert into menu_item (id, version, name, caption, message, params, controller, action, image_src, price, menu_type, menu_id) values (5,1,'Pizza','Thin crust with your choice of toppings',null,null,'roomService','menuItemInfo','../assets/img/fpo_roomservice.png','$15.99','food',2);
insert into menu_item (id, version, name, caption, message, params, controller, action, image_src, price, menu_type, menu_id) values (6,1,'Hamburger','Hot off the grill',null,null,'roomService','menuItemInfo','../assets/img/fpo_roomservice.png','$8.99','food',2);
insert into menu_item (id, version, name, caption, message, params, controller, action, image_src, price, menu_type, menu_id) values (7,1,'Coke Products','Your choice of Coke, Sprite, Diet Coke',null,null,'roomService','menuItemInfo','../assets/img/fpo_roomservice.png','$3.99','drink',2);
insert into menu_item (id, version, name, caption, message, params, controller, action, image_src, price, menu_type, menu_id) values (8,1,'Filet Mignon','Served with side of vegetables',null,null,'roomService','menuItemInfo','../assets/img/fpo_roomservice.png','$29.99','food',3);
insert into menu_item (id, version, name, caption, message, params, controller, action, image_src, price, menu_type, menu_id) values (9,1,'Sushi','Tuna, Salmon, and California Rolls',null,null,'roomService','menuItemInfo','../assets/img/fpo_roomservice.png','$21.99','food',3);
insert into menu_item (id, version, name, caption, message, params, controller, action, image_src, price, menu_type, menu_id) values (10,1,'Wine','Red or White',null,null,'roomService','menuItemInfo','../assets/img/fpo_roomservice.png','$25.00','drink',3);
insert into menu_item (id, version, name, caption, message, params, controller, action, image_src, price, menu_type, menu_id) values (11,1,'Ice Cream','Chocolate and Vanilla',null,null,'roomService','menuItemInfo','../assets/img/fpo_roomservice.png','$6.99','food',4);
insert into menu_item (id, version, name, caption, message, params, controller, action, image_src, price, menu_type, menu_id) values (12,1,'Pizza','Thin crust with your choice of toppings',null,null,'roomService','menuItemInfo','../assets/img/fpo_roomservice.png','$15.99','food',4);
insert into menu_item (id, version, name, caption, message, params, controller, action, image_src, price, menu_type, menu_id) values (13,1,'Cookies','Chocolate Chip and Sugar',null,null,'roomService','menuItemInfo','../assets/img/fpo_roomservice.png','$3.99','food',4);
--property 2
insert into menu_item (id, version, name, caption, message, params, controller, action, image_src, price, menu_type, menu_id) values (14,1,'Waffles','Served with syrup and your choice of fruit ',null,null,'roomService','menuItemInfo','../assets/img/fpo_roomservice.png','$9.99','food',5);
insert into menu_item (id, version, name, caption, message, params, controller, action, image_src, price, menu_type, menu_id) values (15,1,'Eggs Benedict','Traditional style',null,null,'roomService','menuItemInfo','../assets/img/fpo_roomservice.png','$13.99','food',5);
insert into menu_item (id, version, name, caption, message, params, controller, action, image_src, price, menu_type, menu_id) values (16,1,'Coffee','French Roast',null,null,'roomService','menuItemInfo','../assets/img/fpo_roomservice.png','$3.99','drink',5);
insert into menu_item (id, version, name, caption, message, params, controller, action, image_src, price, menu_type, menu_id) values (17,1,'Hot Oatmeal','With your choice of toppings',null,null,'roomService','menuItemInfo','../assets/img/fpo_roomservice.png','$6.99','food',5);
insert into menu_item (id, version, name, caption, message, params, controller, action, image_src, price, menu_type, menu_id) values (18,1,'Pizza','Thin crust with your choice of toppings',null,null,'roomService','menuItemInfo','../assets/img/fpo_roomservice.png','$15.99','food',6);
insert into menu_item (id, version, name, caption, message, params, controller, action, image_src, price, menu_type, menu_id) values (19,1,'Hamburger','Hot off the grill',null,null,'roomService','menuItemInfo','../assets/img/fpo_roomservice.png','$8.99','food',6);
insert into menu_item (id, version, name, caption, message, params, controller, action, image_src, price, menu_type, menu_id) values (20,1,'Coke Products','Your choice of Coke, Sprite, Diet Coke',null,null,'roomService','menuItemInfo','../assets/img/fpo_roomservice.png','$3.99','drink',6);
insert into menu_item (id, version, name, caption, message, params, controller, action, image_src, price, menu_type, menu_id) values (21,1,'Filet Mignon','Served with side of vegetables',null,null,'roomService','menuItemInfo','../assets/img/fpo_roomservice.png','$29.99','food',7);
insert into menu_item (id, version, name, caption, message, params, controller, action, image_src, price, menu_type, menu_id) values (22,1,'Sushi','Tuna, Salmon, and California Rolls',null,null,'roomService','menuItemInfo','../assets/img/fpo_roomservice.png','$21.99','food',7);
insert into menu_item (id, version, name, caption, message, params, controller, action, image_src, price, menu_type, menu_id) values (23,1,'Wine','Red or White',null,null,'roomService','menuItemInfo','../assets/img/fpo_roomservice.png','$25.00','drink',7);
insert into menu_item (id, version, name, caption, message, params, controller, action, image_src, price, menu_type, menu_id) values (24,1,'Ice Cream','Chocolate and Vanilla',null,null,'roomService','menuItemInfo','../assets/img/fpo_roomservice.png','$6.99','food',8);
insert into menu_item (id, version, name, caption, message, params, controller, action, image_src, price, menu_type, menu_id) values (25,1,'Pizza','Thin crust with your choice of toppings',null,null,'roomService','menuItemInfo','../assets/img/fpo_roomservice.png','$15.99','food',8);
insert into menu_item (id, version, name, caption, message, params, controller, action, image_src, price, menu_type, menu_id) values (26,1,'Cookies','Chocolate Chip and Sugar',null,null,'roomService','menuItemInfo','../assets/img/fpo_roomservice.png','$3.99','food',8);
--property 3
insert into menu_item (id, version, name, caption, message, params, controller, action, image_src, price, menu_type, menu_id) values (27,1,'Waffles','Served with syrup and your choice of fruit ',null,null,'roomService','menuItemInfo','../assets/img/fpo_roomservice.png','$9.99','food',9);
insert into menu_item (id, version, name, caption, message, params, controller, action, image_src, price, menu_type, menu_id) values (28,1,'Eggs Benedict','Traditional style',null,null,'roomService','menuItemInfo','../assets/img/fpo_roomservice.png','$13.99','food',9);
insert into menu_item (id, version, name, caption, message, params, controller, action, image_src, price, menu_type, menu_id) values (29,1,'Coffee','French Roast',null,null,'roomService','menuItemInfo','../assets/img/fpo_roomservice.png','$3.99','drink',9);
insert into menu_item (id, version, name, caption, message, params, controller, action, image_src, price, menu_type, menu_id) values (30,1,'Hot Oatmeal','With your choice of toppings',null,null,'roomService','menuItemInfo','../assets/img/fpo_roomservice.png','$6.99','food',9);
insert into menu_item (id, version, name, caption, message, params, controller, action, image_src, price, menu_type, menu_id) values (31,1,'Pizza','Thin crust with your choice of toppings',null,null,'roomService','menuItemInfo','../assets/img/fpo_roomservice.png','$15.99','food',10);
insert into menu_item (id, version, name, caption, message, params, controller, action, image_src, price, menu_type, menu_id) values (32,1,'Hamburger','Hot off the grill',null,null,'roomService','menuItemInfo','../assets/img/fpo_roomservice.png','$8.99','food',10);
insert into menu_item (id, version, name, caption, message, params, controller, action, image_src, price, menu_type, menu_id) values (33,1,'Coke Products','Your choice of Coke, Sprite, Diet Coke',null,null,'roomService','menuItemInfo','../assets/img/fpo_roomservice.png','$3.99','drink',10);
insert into menu_item (id, version, name, caption, message, params, controller, action, image_src, price, menu_type, menu_id) values (34,1,'Filet Mignon','Served with side of vegetables',null,null,'roomService','menuItemInfo','../assets/img/fpo_roomservice.png','$29.99','food',11);
insert into menu_item (id, version, name, caption, message, params, controller, action, image_src, price, menu_type, menu_id) values (35,1,'Sushi','Tuna, Salmon, and California Rolls',null,null,'roomService','menuItemInfo','../assets/img/fpo_roomservice.png','$21.99','food',11);
insert into menu_item (id, version, name, caption, message, params, controller, action, image_src, price, menu_type, menu_id) values (36,1,'Wine','Red or White',null,null,'roomService','menuItemInfo','../assets/img/fpo_roomservice.png','$25.00','drink',11);
--property 4
insert into menu_item (id, version, name, caption, message, params, controller, action, image_src, price, menu_type, menu_id) values (37,1,'Waffles','Served with syrup and your choice of fruit ',null,null,'roomService','menuItemInfo','../assets/img/fpo_roomservice.png','$9.99','food',12);
insert into menu_item (id, version, name, caption, message, params, controller, action, image_src, price, menu_type, menu_id) values (38,1,'Eggs Benedict','Traditional style',null,null,'roomService','menuItemInfo','../assets/img/fpo_roomservice.png','$13.99','food',12);
insert into menu_item (id, version, name, caption, message, params, controller, action, image_src, price, menu_type, menu_id) values (39,1,'Coffee','French Roast',null,null,'roomService','menuItemInfo','../assets/img/fpo_roomservice.png','$3.99','drink',12);
insert into menu_item (id, version, name, caption, message, params, controller, action, image_src, price, menu_type, menu_id) values (40,1,'Hot Oatmeal','With your choice of toppings',null,null,'roomService','menuItemInfo','../assets/img/fpo_roomservice.png','$6.99','food',12);
insert into menu_item (id, version, name, caption, message, params, controller, action, image_src, price, menu_type, menu_id) values (41,1,'Pizza','Thin crust with your choice of toppings',null,null,'roomService','menuItemInfo','../assets/img/fpo_roomservice.png','$15.99','food',13);
insert into menu_item (id, version, name, caption, message, params, controller, action, image_src, price, menu_type, menu_id) values (42,1,'Hamburger','Hot off the grill',null,null,'roomService','menuItemInfo','../assets/img/fpo_roomservice.png','$8.99','food',13);
insert into menu_item (id, version, name, caption, message, params, controller, action, image_src, price, menu_type, menu_id) values (43,1,'Coke Products','Your choice of Coke, Sprite, Diet Coke',null,null,'roomService','menuItemInfo','../assets/img/fpo_roomservice.png','$3.99','drink',13);
insert into menu_item (id, version, name, caption, message, params, controller, action, image_src, price, menu_type, menu_id) values (44,1,'Filet Mignon','Served with side of vegetables',null,null,'roomService','menuItemInfo','../assets/img/fpo_roomservice.png','$29.99','food',14);
insert into menu_item (id, version, name, caption, message, params, controller, action, image_src, price, menu_type, menu_id) values (45,1,'Sushi','Tuna, Salmon, and California Rolls',null,null,'roomService','menuItemInfo','../assets/img/fpo_roomservice.png','$21.99','food',14);
insert into menu_item (id, version, name, caption, message, params, controller, action, image_src, price, menu_type, menu_id) values (46,1,'Wine','Red or White',null,null,'roomService','menuItemInfo','../assets/img/fpo_roomservice.png','$25.00','drink',14);

------------------------------------
-- admin_user
INSERT INTO admin_user( id, version, password, servicetype, user_name, property_id) VALUES (1, 1, 'admin', 'RoomSvc', 'admin', 1);
INSERT INTO admin_user( id, version, password, servicetype, user_name, property_id) VALUES (2, 1, 'admin', 'RoomSvc', 'adminroomsvc', 1);
INSERT INTO admin_user( id, version, password, servicetype, user_name, property_id) VALUES (3, 1, 'admin', 'HelpDsk', 'adminhelpdsk', 1);
INSERT INTO admin_user( id, version, password, servicetype, user_name, property_id) VALUES (4, 1, 'admin', 'FoodSvc', 'adminfoodsvc', 1);
INSERT INTO admin_user( id, version, password, servicetype, user_name, property_id) VALUES (5, 1, 'admin', 'Concierge', 'admin', 2);
INSERT INTO admin_user( id, version, password, servicetype, user_name, property_id) VALUES (6, 1, 'admin', 'RoomSvc', 'admin2', 2);
INSERT INTO admin_user( id, version, password, servicetype, user_name, property_id) VALUES (7, 1, 'admin', 'RoomSvc', 'adminroomsvc2', 2);
INSERT INTO admin_user( id, version, password, servicetype, user_name, property_id) VALUES (8, 1, 'admin', 'RoomSvc', 'admin3', 3);
INSERT INTO admin_user( id, version, password, servicetype, user_name, property_id) VALUES (9, 1, 'admin', 'RoomSvc', 'adminroomsvc3', 3);
INSERT INTO admin_user( id, version, password, servicetype, user_name, property_id) VALUES (10, 1, 'admin', 'RoomSvc', 'admin4', 4);
INSERT INTO admin_user( id, version, password, servicetype, user_name, property_id) VALUES (11, 1, 'admin', 'RoomSvc', 'adminroomsvc4', 4);

