INSERT 
INTO rss_test.parses(site_id, element_parse, attribute_parse) 
VALUES
(1, 'div#main-content > ol > li > a', 'href'),
(2, 'div.box > a', 'href'),
(3, 'ul.blocks-gallery-grid > li > figure > a', 'href'),
(4, 'div.entry-content > ol > li > a', 'href'),
(5, 'div.kizi > p:not(.left_balloon) > a', 'href'),
(6, 'div#the-content > p > a > img', 'src'),
(7, 'div#the-content > p > a > img', 'src'),
(8, 'div.entry-content > p > img', 'src'),
(8, 'div.entry-content > p > img', 'data-src'),
(9, 'div#the-content > p > a', 'href'),
(10, 'div#the-content > center > div > a', 'href');