/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : news_website

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2023-03-16 11:51:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin_information
-- ----------------------------
DROP TABLE IF EXISTS `admin_information`;
CREATE TABLE `admin_information` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `username` varchar(20) NOT NULL COMMENT '账号',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `role` int(11) unsigned DEFAULT '0' COMMENT '角色',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_information
-- ----------------------------
INSERT INTO `admin_information` VALUES ('1', '123', '123', '1', '2022-01-23 17:05:19', '2023-03-02 18:12:20');
INSERT INTO `admin_information` VALUES ('50', 'rendong', 'e26771f4031ec48e25c6bb09847d2dce', '1', '2022-01-30 11:31:09', '2023-03-07 21:08:45');
INSERT INTO `admin_information` VALUES ('56', 'mms', 'e0a6731841a9265d5d99af213b23ad5f', '0', '2022-05-09 13:48:46', '2022-05-09 13:48:46');

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `picture_path` varchar(150) DEFAULT NULL COMMENT '图片',
  `title` varchar(100) NOT NULL COMMENT '标题',
  `release_time` date NOT NULL COMMENT '发布时间',
  `hits` bigint(20) NOT NULL DEFAULT '0' COMMENT '点击率',
  `content` text NOT NULL COMMENT '内容',
  `news_category_id` int(10) unsigned NOT NULL COMMENT '文章类别id',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_news_category_id` (`news_category_id`),
  KEY `idx_title` (`title`)
) ENGINE=InnoDB AUTO_INCREMENT=251 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('187', null, '支持单位', '2023-03-10', '187', '<p><span style=\"background-color: rgb(255, 255, 255);\">Organizer&nbsp;</span></p><p><img src=\"http://localhost:8085/image/e2b214e5-8e0a-4c49-9d6c-4dbe33ec8bcb.png\" style=\"\" width=\"143\">   <img src=\"http://localhost:8085/image/c8ce45a0-6f86-43b7-a42f-73b25c6c4c5b.png\" style=\"\" width=\"143\">   </p>', '46', '2023-03-10 00:26:26', '2023-03-16 11:39:33');
INSERT INTO `news` VALUES ('195', 'http://123.60.4.254:8085/image/44c67be0-b6a6-4b99-8cd1-c719ae7cdd79.png', '轮播1', '2023-03-10', '0', '', '45', '2023-03-10 16:36:20', '2023-03-10 16:36:20');
INSERT INTO `news` VALUES ('196', 'http://123.60.4.254:8085/image/001f2b2a-cdde-421e-8938-e3d5332a0c28.png', '轮播2', '2023-03-10', '0', '', '45', '2023-03-10 16:36:37', '2023-03-10 16:36:37');
INSERT INTO `news` VALUES ('203', null, '附近住宿', '2023-03-10', '38', '<p>The organizing committee will not provide accommodation for the delegates, please book your rooms as soon as possible.</p><p>And please note that hotels will not contact the delegates for room reservation and ask for your credit card information. Be Careful with the frauds.</p>', '35', '2023-03-10 17:46:50', '2023-03-16 11:39:00');
INSERT INTO `news` VALUES ('204', null, '最新新闻', '2023-03-10', '30', '<p><span style=\"color: rgb(0, 102, 204);\">&nbsp;August 12, 2023</span></p><p>2023 1th International Conference on Data Science and Knowledge Engineering (ICDSKE 2023) will be held in Xiong’an New Area in Beijing, China.</p>', '37', '2023-03-10 17:50:32', '2023-03-16 11:39:01');
INSERT INTO `news` VALUES ('206', null, '重要时间', '2023-03-10', '161', '<p>Conference Dates: <strong style=\"color: rgb(0, 102, 204);\">August 12, 2023</strong></p>', '43', '2023-03-10 17:53:36', '2023-03-16 11:39:33');
INSERT INTO `news` VALUES ('217', null, 'Keynote Speakers', '2023-03-11', '26', '<p><img src=\"http://123.60.4.254:8085/image/69cb63e1-36bb-4a30-b851-c051f2ab4d37.png\">        </p><p><strong class=\"ql-size-large\">Professor </strong><strong class=\"ql-size-large\" style=\"color: rgb(51, 51, 51);\">Wei Fang</strong></p><p><strong class=\"ql-size-large\">Bio：</strong></p><p>He is the head of the cloud computing team of the School of Computing, Nanjing University of Information Technology, and the director of the Institute of Artificial Intelligence and Meteorological Big Data. In recent years, he has presided over 1 general project of the National Natural Science Foundation, 4 provincial and ministerial level projects, 3 municipal and ministerial level projects, and mainly participated in 9 national, provincial and ministerial level scientific research projects; More than 30 academic papers have been published, including 25 retrieved by SCI and EI; 9 national invention patents were granted; 10 software copyrights were obtained. Served as the chairman of workshops of previous international conferences of ICAIS and TURC, the academic branch of the Turing Conference of China_ AIS 2019, MLAI2022 International Conference TPC Member, guest editors of various SCI journals and reviewers of IEEE Transactions on Circuits and Systems for Video Technology, Pattern Recognition, Information Fusion, Neurocomputing, IETE TECHNICAL REVIEW, Journal of Supercomputing, Electronic Journal, Journal of Communications and other important academic journals.</p>', '27', '2023-03-11 00:46:04', '2023-03-16 11:34:20');
INSERT INTO `news` VALUES ('225', null, '简介', '2023-03-13', '93', '<p><span style=\"color: rgb(0, 102, 204);\">2023 1th International Conference on Data Science and Knowledge Engineering (ICDSKE 2023) </span>will be held on <span style=\"color: rgb(0, 102, 204);\">August 12, 2023</span> in <span style=\"color: rgb(0, 102, 204);\">Xiong’an New Area</span> in<span style=\"color: rgb(0, 102, 204);\"> Beijing</span>,<span style=\"color: rgb(0, 102, 204);\"> China</span>. The aim of ICDSKE is to provide a platform for researchers, engineers, academicians as well as industrial professionals from all over the world to present their research results and development activities in Data Science and Knowledge Engineering. This conference provides opportunities for the delegates to exchange new ideas and application experiences face to face, to establish business or research relations and to find global partners for future collaboration.</p>', '42', '2023-03-13 21:49:11', '2023-03-16 11:39:33');
INSERT INTO `news` VALUES ('226', null, '组委会', '2023-03-13', '29', '<p><strong style=\"color: rgb(51, 51, 51);\">General Chairs:</strong></p><p><span style=\"color: rgb(51, 51, 51);\">Prof. Victor S. Sheng, Texas Tech University, USA</span></p><p><br></p><p><br></p><p><strong style=\"color: rgb(51, 51, 51);\">Technical Program Chairs:</strong></p><p><span style=\"color: rgb(51, 51, 51);\">Prof. Wei Fang, Nanjing University of Information Science and Technology, China</span></p><p><br></p><p><br></p><p><strong><span class=\"ql-cursor\">﻿</span>﻿Technical&nbsp;Program&nbsp;Committee&nbsp;Members:</strong></p><p>Prof.&nbsp;Zuping&nbsp;Zhang,&nbsp;Central&nbsp;South&nbsp;University,&nbsp;China</p><p>Prof.&nbsp;Yunliang&nbsp;Chen,&nbsp;China&nbsp;University&nbsp;of&nbsp;Geosciences,&nbsp;China</p><p>Assoc.&nbsp;Prof.,Yidong&nbsp;Chen,&nbsp;Xiamen&nbsp;University,China</p><p><br></p><p><br></p><p><strong style=\"color: rgb(51, 51, 51);\">Organization Chairs:</strong></p><p><span style=\"color: rgb(51, 51, 51);\">Prof. Wei Fang, Nanjing University of Information Science and Technology, China</span></p><p><br></p><p><br></p><p><strong style=\"color: rgb(51, 51, 51);\">﻿Organization Committee Members:</strong></p><p><span style=\"color: rgb(51, 51, 51);\">Zhong Yuan, Nanjing University of Information Science and Technology, China</span></p><p><span style=\"color: rgb(51, 51, 51);\">Yu Sha, Nanjing University of Information Science and Technology, China</span></p><p><span style=\"color: rgb(51, 51, 51);\">Meihan Qi, Nanjing University of Information Science and Technology, China</span></p><p><span style=\"color: rgb(51, 51, 51);\">Wenhe Lu, Nanjing University of Information Science and Technology, China</span></p><p><span style=\"color: rgb(51, 51, 51);\">Jiaxin Li, Nanjing University of Information Science and Technology, China</span></p><p><span style=\"color: rgb(51, 51, 51);\">Xiaozhi Zhang, Nanjing University of Information Science and Technology, China</span></p><p><span style=\"color: rgb(51, 51, 51);\">Haoxi Wang, Nanjing University of Information Science and Technology, China</span></p><p><span style=\"color: rgb(51, 51, 51);\">Binglun Wang, Nanjing University of Information Science and Technology, China</span></p><p><span style=\"color: rgb(51, 51, 51);\">Juan Du, Nanjing University of Information Science and Technology, China</span></p><p><span style=\"color: rgb(51, 51, 51);\">Yuxiang Fu, Nanjing University of Information Science and Technology, China</span></p><p><span style=\"color: rgb(51, 51, 51);\">Enyi Tao, Nanjing University of Information Science and Technology, China</span></p><p><span style=\"color: rgb(51, 51, 51);\">Haiqiang Zheng, Nanjing University of Information Science and Technology, China</span></p>', '47', '2023-03-13 21:52:07', '2023-03-16 11:41:46');
INSERT INTO `news` VALUES ('229', null, '流程', '2023-03-14', '56', '<p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"><strong class=\"ql-font-Microsoft-YaHei\">Instruction for Oral Presentations</strong></p><p class=\"ql-align-justify\"><span class=\"ql-font-Microsoft-YaHei\">1. Timing: A maximum of 15 minutes in total, including presentation and discussion. Please be considerable once the Program is completed the next speaker should also be allocated with reasonable amount of time.</span></p><p class=\"ql-align-justify\"><span class=\"ql-font-Microsoft-YaHei\">2. For conference presentation, you can use your own computer or copy your presentation file into the conference computer from CD or USB drive, and make sure you have scanned and cleaned viruses beforehand. Speakers are required to meet her/his session Chair in the corresponding session room at least 10 minutes before the session starts to get things ready or copy the slide file (PPT or PDF) into the conference computer.&nbsp;</span></p><p class=\"ql-align-justify\"><span class=\"ql-font-Microsoft-YaHei\">3.&nbsp;It is also suggested that you email a copy of your presentation to your personal email box as a backup. If for some reason the files cannot be accessed from your flash drive, you can download them to the computer from your email.&nbsp;</span></p><p class=\"ql-align-justify\"><span class=\"ql-font-Microsoft-YaHei\">4. Please note that each session room will be equipped with an LCD projector, screen, laser pointer, microphone, and a laptop with general presentation software such as the Microsoft PowerPoint and Adobe Reader. Please make sure that your files are compatible and readable with our operation system by using commonly used fronts and symbols. If you plan to use your own computer, please test the connection and make sure it works well before your presentation.&nbsp;</span></p><p class=\"ql-align-justify\"><span class=\"ql-font-Microsoft-YaHei\">5. Movies: If your files contain movies please make sure that they are well formatted and connected to the main files.</span></p><p class=\"ql-align-justify\"><span class=\"ql-font-Microsoft-YaHei\">&nbsp;</span></p><p class=\"ql-align-justify\"><strong class=\"ql-font-Microsoft-YaHei\">Instructions for Poster Presentations</strong></p><p class=\"ql-align-justify\"><span class=\"ql-font-Microsoft-YaHei\">1. Maximum poster size is 59.4 CM wide by 84.1 CM high (A1).&nbsp;</span></p><p class=\"ql-align-justify\"><span class=\"ql-font-Microsoft-YaHei\">2. Posters are required to be optimized and attractive.&nbsp;Information should be visible from a proper distance, say, one meter away.</span></p><p class=\"ql-align-justify\"><span class=\"ql-font-Microsoft-YaHei\">3. Please note that during your poster session, you as the author should stay by your poster and ready to explain and discuss your paper with visiting delegates.</span></p><p><br></p>', '40', '2023-03-14 16:09:49', '2023-03-16 11:42:02');
INSERT INTO `news` VALUES ('230', null, '地址', '2023-03-14', '27', '<p><strong>Address</strong>: Xiong’an New Area, Beijing, China</p><p><br></p><p><img src=\"http://123.60.4.254:8085/image/12e123ac-5b23-4c44-bfa5-438ae4df9eb8.png\" width=\"550\"></p><p>﻿</p><p><strong>*Notice</strong>:</p><p>Please note that the conference hotel or conference secretary will not contact any participant for reservation, please be careful when anyone asks you to provide your credit card information to book rooms for you. If you have any questions, please contact us via the conference email address or phone or wechat on the contact page.</p><p><br></p><p><br></p>', '39', '2023-03-14 16:17:42', '2023-03-16 11:42:05');
INSERT INTO `news` VALUES ('234', null, 'Call for papers', '2023-03-14', '24', '<p><strong style=\"color: rgb(63, 49, 81);\" class=\"ql-font-Microsoft-YaHei\">Topics include but are not limited to the following areas:</strong></p>', '29', '2023-03-14 16:22:35', '2023-03-16 11:41:50');
INSERT INTO `news` VALUES ('239', null, '联系我们', '2023-03-15', '20', '<p>The secretariat of ICDSKE 2023 will collect your paper contributions and respond to your queries.</p><p>*Notice:</p><p>Organizing committee or conference secretary will not ask for your credit card information in any form for room reservation or tickets. Be careful when anyone asks for it.</p><p><br></p><p><img src=\"http://www.csai.org/style/img/logos/contact-icon.jpg\" height=\"49\" width=\"50\"><strong>Ms. Du                            </strong><img src=\"http://www.csai.org/style/img/logos/phone.png\" height=\"49\" width=\"50\"><strong>13345020053 (service hours are from 10:00 to 18:30 (UTC+08:00) Monday through Friday)</strong></p><p><img src=\"http://www.csai.org/style/img/logos/email-icon.png\" height=\"50\" width=\"50\"><strong style=\"color: rgb(0, 102, 204);\">2605802502@qq.com</strong><strong> </strong>  <img src=\"http://www.csai.org/style/img/logos/2144.png\" height=\"50\" width=\"50\"><a href=\"http://123.60.4.254:8080/home\" rel=\"noopener noreferrer\" target=\"_blank\" style=\"color: rgb(0, 102, 204);\"><strong>ICDSKE 2023</strong></a><strong>&nbsp;</strong></p>', '41', '2023-03-15 15:25:51', '2023-03-16 11:42:06');
INSERT INTO `news` VALUES ('242', null, 'zhuce', '2023-03-15', '5', '<p><strong style=\"color: rgb(51, 51, 51);\">Note:</strong></p><p><span style=\"color: rgb(51, 51, 51);\">1)&nbsp;At least one author of each accepted paper must register using the author registration rate to ensure that the paper is included in the conference proceedings. The author registration must be received before and by the specified author registration deadline.&nbsp;</span></p><p><span style=\"color: rgb(51, 51, 51);\">2)&nbsp;Payment of the registration fee covers the cost of proceedings publishing, custom taxes, conference venue and session rooms renting, coffee/tea breaks, conference banquet, and all lunches and dinners during the conference. Notice that the registration fee does not cover travelling fee and hotel fee.</span></p><p><span style=\"color: rgb(51, 51, 51);\">3)&nbsp;Payments sent by bank transfer must be free of charges for ICDSKE 2023 and only the bank transfer is accepted for author registration.&nbsp;</span></p><p><span style=\"color: rgb(51, 51, 51);\">4)&nbsp;If the same author has more than one paper accepted by conference, each paper is required for registration separately.&nbsp;</span></p><p><span style=\"color: rgb(51, 51, 51);\">5)&nbsp;An Official Receipt for the payment will be passed to the registrant on the conference.</span></p>', '38', '2023-03-15 23:39:05', '2023-03-16 11:46:29');
INSERT INTO `news` VALUES ('248', null, '发表', '2023-03-16', '3', '<p class=\"ql-align-justify\">After a careful reviewing process, all accepted papers will be published in the <strong style=\"color: rgb(0, 102, 204);\">Conference Proceedings</strong>, and submitted to <strong style=\"color: rgb(0, 102, 204);\">EI Compendex</strong>&nbsp;for indexing.Outstanding papers will be invited for possible publication in <strong style=\"color: rgb(0, 102, 204);\">SCl-indexed journals</strong>.</p><p><br></p><p class=\"ql-align-justify\"><strong>Note:</strong></p><p class=\"ql-align-justify\">All submitted articles should report original results, experimental or theoretical, not previously published or being under consideration for publication elsewhere. Articles submitted to the conference should meet these criteria. We firmly believe that ethical conduct is the most essential virtue of any academics. Hence, any act of plagiarism or other misconduct is totally unacceptable and cannot be tolerated.</p><p><br></p>', '50', '2023-03-16 00:01:15', '2023-03-16 11:41:58');
INSERT INTO `news` VALUES ('249', null, '提交', '2023-03-16', '2', '<p>1. All manuscripts should be submitted in Word / PDF file format by the following system:&nbsp;</p><p><a href=\"https://cmt3.research.microsoft.com/ICDSKE2023\" rel=\"noopener noreferrer\" target=\"_blank\" style=\"color: rgb(0, 102, 204);\"><strong>https://cmt3.research.microsoft.com/ICDSKE2023</strong></a></p><p>&nbsp;</p><p>Note: Papers must be submitted to the appropriate Track.</p><p><br></p><p>2. All submissions must be in English. The papers should have 8~12 ICDSKE pages in length, including figures and references. Authors should use<span style=\"color: rgb(255, 0, 0);\">&nbsp;</span><a href=\"http://www.icaisconf.com/?attachment_id=18732&amp;download=1\" rel=\"noopener noreferrer\" target=\"_blank\" style=\"background-color: transparent;\"><strong> ICDSKE paper format template</strong></a><span style=\"color: rgb(0, 102, 204);\">&nbsp;</span>to prepare their papers.</p><p><br></p><p>3. The submitted papers must not be previously published anywhere, and must not be submitted to any other conferences before and during the ICDSKE 2023 review process. Submitting a paper to the conference means that if the paper was accepted, at least one author will register and attend the conference to present the paper.</p><p><br></p><p>4. For any difficulties and other issues regarding submission, please contact:<strong> </strong><strong style=\"color: rgb(0, 102, 204);\">2605802502@qq.com</strong><strong>.</strong></p><p><br></p><p>Acceptance</p><p>Manuscripts should present the current research in the areas identified in the call for papers. All submitted manuscripts will be reviewed by experts in the fields and will be judged from the aspects of problem significance, contributions, originality, correctness, technical strength, quality of presentation, and relevance to the conference attendees.</p>', '31', '2023-03-16 11:37:51', '2023-03-16 11:41:52');
INSERT INTO `news` VALUES ('250', null, '中文', '2023-03-16', '1', '<h2><strong>第一届数据科学与知识工程国际会议</strong></h2><p><br></p><p>数据科学倚赖海量数据，是基于统计、编程、知识领域，对数据进行发现、处理，从中提取有用信息，而知识工程就是从数据里凝练出知识，这是人工智能的核心。数据科学与金融商业结合孕育了商业分析，与机械结合推动了自动化，在人工智能领域则衍生出计算机视觉、自然语言处理、语音识别、知识图谱等主要分支。深度学习作为人工智能应用于数据科学庞杂数据处理的多层神经网络机器学习技术，是对数据科学的重要补充，更是未来各层级各产业场景应用与发展的强力推动。在人工智能的浪潮席卷全球之际，南京信息工程大学人工智能与气象大数据研究所紧跟时代步伐，我们很荣幸地宣布<span style=\"color: rgb(161, 0, 0);\">，</span><strong style=\"color: rgb(0, 102, 204);\">第一届数据科学与知识工程国际会议&nbsp;(ICDSKE 2023)</strong>将于<strong style=\"color: rgb(0, 102, 204);\">2023年8月12日</strong>在<strong style=\"color: rgb(0, 102, 204);\">中国.北京.雄安新区</strong>召开，旨在为业界建立一个广泛、有效的交流合作平台，让我们及时了解行业发展动态、掌握最新技术，拓宽研究视野，推动学术进步以及技术成果的高效应用。与会代表不仅可以聆听国内外知名专家精彩报告，并且可以亲自参与其中与来自世界各地的专家学者进行面对面的交流与探讨。热忱欢迎从事相关技术研究的专家、学者和专业技术人员踊跃投稿并参加大会。</p><p><br></p><p class=\"ql-align-justify\"><strong>一：征稿时间</strong></p><p class=\"ql-align-justify\">第一届数据科学与知识工程国际会议——ICDSKE 2023正式开始征集投稿。</p><p class=\"ql-align-justify\">征稿截止时间: </p><p class=\"ql-align-justify\">听众注册截止时间： </p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"><strong>二：征稿主题</strong></p><p class=\"ql-align-justify\">征稿主题详情请参照：<a href=\"http://123.60.4.254:8080/papers/cpf\" rel=\"noopener noreferrer\" target=\"_blank\"><strong>征稿主题</strong></a></p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"><strong>三：投稿说明</strong></p><p>1.所有手稿应通过以下系统以Word/PDF文件格式提交(<a href=\"https://cmt3.research.microsoft.com/ICDSKE2023\" rel=\"noopener noreferrer\" target=\"_blank\"><strong>投稿链接</strong></a>)</p><p>   注：论文必须提交至相应的轨道。</p><h4>2.所有提交的材料必须是英文。论文应有8~12页ICDSKE，包括数字和参考文献。作者应使用<strong style=\"color: rgb(0, 102, 204);\">&nbsp;</strong><a href=\"http://www.icaisconf.com/?attachment_id=18732&amp;download=1\" rel=\"noopener noreferrer\" target=\"_blank\" style=\"background-color: transparent;\">ICDSKE 论文格式模板 </a>准备论文。</h4><p>3.提交的论文之前不得在任何地方发表，也不得在ICDSKE 2023 审查过程之前和期间提交给任何其他会议。向会议提交论文意味着如果论文被接受，至少有一位作者将注册并出席会议以提交论文。</p><p>4.有关提交的任何困难和其他问题，请联系：<strong style=\"color: rgb(0, 102, 204);\">2605802502@qq.com</strong></p><p class=\"ql-align-justify\">5.手稿应介绍论文征集中确定的领域的当前研究。所有提交的手稿将由该领域的专家进行审查，并将从问题的重要性、贡献、独创性、正确性、技术实力、演示质量以及与与会者的相关性等方面进行判断。</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"><strong>四：注册说明</strong></p><p class=\"ql-align-justify\">投稿结束后，我们将根据您的文章主题，提交相关领域的专家审稿。</p><p class=\"ql-align-justify\">被录取的文章，须在截止日前完成注册。</p><p>注册费用为<span style=\"color: rgb(51, 51, 51);\">550 美元 (3500 人民币)，详情可登陆本网站Register模块查看。</span></p><p><br></p><p><strong>五：出版和检索说明</strong></p><p>经过仔细审查，所有被接受的论文将发表在EI论文集中。优秀论文将被推荐到SCl期刊发表。</p><p><br></p><p><strong>六：联系方式</strong></p><p>如果您想了解ICDSKE 2023 会议更多信息，或您有好的建议或意见，欢迎联系我们。</p><p>联系人：杜女士</p><p>邮箱:&nbsp;2605802502@qq.com</p><p>电话：13345020053</p>', '48', '2023-03-16 11:50:50', '2023-03-16 11:50:53');

-- ----------------------------
-- Table structure for news_category
-- ----------------------------
DROP TABLE IF EXISTS `news_category`;
CREATE TABLE `news_category` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `name` varchar(500) NOT NULL COMMENT '新闻类别名称',
  `news_type_id` int(10) unsigned NOT NULL COMMENT '新闻类型id',
  `display_content` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '展示内容',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_name` (`id`,`name`,`news_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news_category
-- ----------------------------
INSERT INTO `news_category` VALUES ('27', 'Keynote Speakers', '3', '1', '2022-01-13 11:42:04', '2023-03-05 14:37:23');
INSERT INTO `news_category` VALUES ('28', 'Invited Speakers ', '3', '1', '2022-01-13 11:42:09', '2023-03-05 14:37:36');
INSERT INTO `news_category` VALUES ('29', 'Call for papers ', '4', '1', '2022-01-13 11:42:15', '2023-03-05 14:37:55');
INSERT INTO `news_category` VALUES ('30', 'Special Session', '4', '1', '2022-01-13 11:42:21', '2023-03-05 14:38:12');
INSERT INTO `news_category` VALUES ('31', 'Paper Submission', '4', '1', '2022-01-13 11:42:26', '2023-03-05 14:38:36');
INSERT INTO `news_category` VALUES ('35', 'Accomodation', '5', '0', '2022-01-13 22:38:55', '2023-03-05 14:39:23');
INSERT INTO `news_category` VALUES ('37', 'Latest News', '5', '0', '2022-01-13 22:39:21', '2023-03-05 14:39:54');
INSERT INTO `news_category` VALUES ('38', 'Register', '6', '0', '2022-01-14 12:20:12', '2023-03-05 14:40:12');
INSERT INTO `news_category` VALUES ('39', 'Conference Venue', '7', '0', '2022-01-14 12:20:20', '2023-03-05 14:40:51');
INSERT INTO `news_category` VALUES ('40', 'Program', '8', '0', '2022-01-14 12:21:19', '2023-03-05 14:41:10');
INSERT INTO `news_category` VALUES ('41', 'Contact Us', '9', '0', '2022-01-14 12:21:37', '2023-03-05 14:41:16');
INSERT INTO `news_category` VALUES ('42', 'About ICDSKE 2023', '1', '0', '2022-01-16 16:01:35', '2023-03-10 17:10:00');
INSERT INTO `news_category` VALUES ('43', 'Important Date', '1', '0', '2022-01-16 16:01:56', '2023-03-08 15:48:43');
INSERT INTO `news_category` VALUES ('44', 'SCI Indexed Journals', '1', '0', '2022-01-16 16:02:03', '2023-03-10 14:49:15');
INSERT INTO `news_category` VALUES ('45', '轮播图', '11', '0', '2022-01-30 11:25:47', '2023-03-05 14:30:58');
INSERT INTO `news_category` VALUES ('46', 'Support', '1', '0', '2023-03-04 15:32:28', '2023-03-08 15:49:04');
INSERT INTO `news_category` VALUES ('47', 'Committee ', '2', '0', '2023-03-04 15:47:10', '2023-03-05 14:41:25');
INSERT INTO `news_category` VALUES ('48', '中文', '10', '0', '2023-03-04 15:52:04', '2023-03-04 15:52:06');
INSERT INTO `news_category` VALUES ('50', 'Publication', '4', '0', '2023-03-15 22:49:35', '2023-03-15 23:09:27');

-- ----------------------------
-- Table structure for news_type
-- ----------------------------
DROP TABLE IF EXISTS `news_type`;
CREATE TABLE `news_type` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `name` varchar(10) NOT NULL COMMENT '新闻类型名称',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news_type
-- ----------------------------
INSERT INTO `news_type` VALUES ('1', 'Home', '2022-01-13 10:08:56', '2023-03-04 15:20:26');
INSERT INTO `news_type` VALUES ('2', 'Committee', '2022-01-13 10:09:04', '2023-03-04 15:24:41');
INSERT INTO `news_type` VALUES ('3', 'Speakers', '2022-01-13 10:09:40', '2023-03-04 15:24:43');
INSERT INTO `news_type` VALUES ('4', 'Papers', '2022-01-13 10:09:55', '2023-03-04 15:24:46');
INSERT INTO `news_type` VALUES ('5', 'Attendees', '2022-01-13 10:10:11', '2023-03-04 15:24:48');
INSERT INTO `news_type` VALUES ('6', 'Register', '2022-01-13 10:10:18', '2023-03-04 15:24:50');
INSERT INTO `news_type` VALUES ('7', 'Venue', '2022-01-13 10:10:25', '2023-03-04 15:24:52');
INSERT INTO `news_type` VALUES ('8', 'Program', '2022-01-13 10:10:30', '2023-03-04 15:24:54');
INSERT INTO `news_type` VALUES ('9', 'Contact', '2022-01-13 10:10:42', '2023-03-04 15:24:56');
INSERT INTO `news_type` VALUES ('10', '中文', '2023-03-04 15:24:03', '2023-03-04 17:41:28');
INSERT INTO `news_type` VALUES ('11', '轮播图', '2023-03-05 14:32:36', '2023-03-05 14:32:39');
