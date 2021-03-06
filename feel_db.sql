Use test;

DROP TABLE IF EXISTS book;

CREATE TABLE `test`.`book` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(100) NOT NULL,
  `description` VARCHAR(255) NOT NULL,
  `author` VARCHAR(100) NOT NULL,
  `isbn` VARCHAR(20) NOT NULL,
  `printYear` INT NOT NULL,
  `readAlready` BIT(1) NOT NULL,
  PRIMARY KEY (`id`))
  COLLATE='utf8_general_ci';

INSERT INTO `book` (`title`,`description`,`author`,`isbn`,`printYear`,`readAlready`)
    VALUES ("Властелин Колец", "Нельзя просто так взять и прочитать Властелина Колец.", "Джон Толкин", "978-5-17-091100-4", 2017, 0),
("Гордость и предубеждение", "Наиболее совершенным из всего, что создано Джейн Остин, считается роман Гордость и предубеждение, до сих пор не утративший ни капли своего неподражаемого очарования и блеска.", "Джейн Остин", "978-5-389-05505-6 ", 2013, 1),
("Автостопом по галактике", "Приключения приспособленца, издателя, тётки и робата в космосе.", "Дуглас Адамс", "978-5-17-085834-7", 2015, 1),
("Гарри Поттер и Кубок Огня", "Очередной гарипоттор, только теперь с кубком.", "Джоан Роулинг", "978-5-389-07789-8 ", 2015, 0),
("Убить пересмешника", "Пронзительная история семьи, живущей в вымышленном маленьком городке на юге Америки, в штате Алабама.", "Харпер Ли", "978-5-17-083520-1", 2017, 0),
("Винни-Пух", "Книга про медведя, свинью, кролика, сову, осла, и всех-всех-всех", "Алан Александр Милн", "978-5-506-00171-3", 2014, 0),
("1984", "Своеобразный антипод второй великой антиутопии XX века - О дивный новый мир Олдоса Хаксли.", "Джордж Оруэлл", "978-5-17-103595-2", 2017, 1),
("Лев, колду́нья и платяно́й шкаф", "Нечто из Хроник Нарнии", "Клайв Стэйплз Льюис", "978-5-699-95481-0", 2017, 0),
("Джейн Эйр", "Литературное наследие сестер Бронте вошло в сокровищницу национальной английской культуры, завоевав признание далеко за пределами Англии.", "Шарлотта Бронте", "978-5-389-05734-0", 2016, 0),
("Уловка-22", "В романе показана жизнь американских летчиков эскадрильи военных бомбардировщиков в последние годы второй мировой войны.", "Джозеф Хеллер", "5-7707-7091-0", 1995, 1),
("Грозовой перевал", "Эта полная любви и ненависти история роковой страсти Хитклифа, приемного сына владельца поместья Грозовой перевал, к дочери хозяина Кэтрин снова и снова находит своего читателя.", "Эмили Бронте", "978-5-389-01323-0", 2016, 0),
("И пели птицы…", "Наиболее известный роман Себастьяна Фолкса, ставший классикой современной английской литературы.", "Себастьян Фолкс", "978-5-905891-55-7", 2014, 0),
("Ребекка", "Несмотря на то, что многие критики и читатели видят в его сюжете некоторое сходство с легендарной Джейн Эйр Шарлотты Бронте, произведение Дафны Дюморье никак нельзя назвать вторичным.", "Дафна Дюморье", "978-5-17-081300-1", 2017, 0),
("Над пропастью во ржи", "Культовый роман ХХ века в блестящем переводе Риты Райт-Ковалевой, ставшем классикой переводческого искусства.", "Джером Сэлинджер", "978-5-699-64814-6", 2017, 0),
("Ветер в ивах", "Сказочная повесть Кеннета Грэма Ветер в ивах рекомендуется для чтения в 3-4-х классах.", "Кеннет Грэм", "978-5-699-84186-8", 2015, 1),
("Большие надежды", "История жизни и крушения надежд молодого Филиппа Пиррипа.", "Чарльз Диккенс", "978-5-389-02083-2", 2011, 0),
("Маленькие женщины", "Увлекательная история о детстве четырех сестер завоевала сердца не одного поколения читателей.", "Луиза Мэй Олкотт", "978-5-699-67531-9", 2014, 0),
("Мандолина капитана Корелли", "Остров, затерянный в Средиземном море. Народ, захваченный вихрем великой войны. Люди, пронесшие страсть через десятилетия. Любовь, не подвластная времени.", "Луи де Берньер", "5-699-07304-3", 2004, 0),
("Война и мир", "Книга на все времена, за одно время не возможно прочитать всю.", "Лев Толстой", "978-5-389-07123-0", 2014, 1),
("Поющие в терновнике", "Любовный роман, поднятый на уровень настоящей литературы.", "Колин Маккалоу", "978-5-17-082887-6", 2013, 0),
("Миддлмарч", "Место его действия - провинциальный городок в средней Англии со всеми его тайнами и загадками, скрывающимися за красивыми фасадами благоустроенных домов.", "Джордж Элиот", "978-5-389-12115-7", 2016, 0),
("Гроздья гнева", "Во время Великой депрессии семья разоренных фермеров вынуждена покинуть свой дом в Оклахоме.", "Джон Стейнбек", "978-5-389-04994-9", 2016, 1),
("Алиса в стране чудес", "Все и так знают о чём эта книга, описания излишни.", "Льюис Кэрролл", "978-5-699-73916-5", 2014, 1),
("Дневник Трейси Бикер", "Трейси живет в детском доме и надеется однажды обрести семью. Эти добрые, трогательные и веселые повести познакомят вас с Трейси, ее дневником и ее надеждами.", "Жаклин Уилсон", "5-353-01652-1", 2004, 0),
("Сто лет одиночества", "История рода Буэндиа - семьи, в которой чудеса столь повседневны, что на них даже не обращают внимания.", "Габриэль Гарсиа Маркес", "978-5-17-071285-4", 2017, 0),
("Столпы Земли", "Роман Кена Фоллетта - грандиозная панорама самых темных лет в истории Англии, когда борьба за престол и междоусобные войны были привычным фоном жизни.", "Кен Фоллетт", "978-5-17-093063-0", 2016, 1);
