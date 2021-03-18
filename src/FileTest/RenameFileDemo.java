package FileTest;

import java.io.File;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/6/27 19:31
 */
public class RenameFileDemo {
    private static String[] showNameList = {"啤酒巨星","失落的阿纳斯塔西娅公主","超级厨王","大破","厨神","征服钱海-蛇与梯子","兔子锅炉","藏宝时间","桥牌老虎机","甜蜜的收获","动物冲浪","超级零点","超级奖金宾果","黄金兔子锅炉","蒸汽朋克英雄","星云","我推","现金蚬","财富之轮","卡萨努瓦","太空逃避物黄金版","太空逃避物","昆虫派对(刮刮卡)","动物足球","锁子甲2","骷髅陷阱","运财酷儿","圣诞老人的秘密","宇宙猫","疯狂的80年代","萨巴宾果","国际鱼虾蟹骰宝","罗马财富","地穴的远征","滚德比","黄金地穴的远征","摇滚船","洛伯杰克","网络扑克","押韵的卷轴-老国王科尔","黎明的面包","红唇诱惑","恐龙迪诺","医生的爱","狗爸爸","急速转轮","新年快乐","为粉红而战","4手双百搭","地狱阿嬷","六线","双百搭","高限制百家乐","双魔","高速扑克","恐怖实验室","龙的鸿运","轮盘钻石版","轮盘","超级赛马","棒球直击","神奇墨水","熊峰战争","掠夺之海","法老宾果","爱尔兰眼睛","富豪生活","小猪财富","累计奖金快车","发现天堂","东方财富","电宾果","水果怪兽","幻影现金","魔法森林","地府烈焰","神秘森林","奇妙7","胖女人辛斯","超级飞行员","泡沫财富","幸运曲奇","四乘四","冻结模糊球","法式轮盘","水果老虎机","精灵宝石","孟买魔术","细菌对对碰","网球最终局","礼品包装","黄金海岸","黄金龙","黄金食尸鬼","疯狂赛道","老太太赛车","大狮鹫","毛茸茸的仙女","万圣节(刮刮卡)","东方珠宝","铃儿响叮当","临门一脚","判若两人","嗬嗬嗬","奥林匹斯山","龙之家","美国酒吧","冒险宫殿","史地大发现","怪物躁狂症","特务珍金","阿拉斯加捕捞","阿瓦隆","沙滩宝贝","巨型银行爆破","月光","疯狂的猴子","马戏篷","小丑扑克","抢银行","侏罗纪大奖","功夫小胖猪","燃烧的欲望","丛林摇摆","狂欢节","基诺","中心球场","亚瑟王","玛雅宾果","昆虫派对","星战传奇","终极破坏","神秘的诱惑","魔术箱","沙发土豆","幸运女巫","幸运数字","财富阶级","妖精的战利品","闪亮的圣诞节","遗产L","万能两点","海盗王","老鹰的翅膀","路易斯安那双","复式黄金轮盘","万圣节","上流社会","章鱼","终极杀手","隔离的宝石","扑克追求","蜜蜂乐园","超级马车赛","优质物业","帽子里的兔子","拉美西斯的财富","埃及女神伊西絲","卡萨缦都","女仕之夜","狮子的骄傲","炫富一族","疯狂的帽子","玛雅公主","海底世界","神秘梦境","纯铂","雷电击","银芳","春假","星梦之吻","夏天","泰利嗬","反转马戏团","雷神","老虎之眼","古墓丽影","财宝宫殿","瞧！","猫头鹰乐园","女孩与枪II","刮刮卡20合一","银行爆破","泰坦之藏匿","冒险之旅","雷神2","泡泡富豪","新娘吉拉","押韵的卷轴-杰克与吉儿","杰森与金羊毛","侏罗记公园","劳斯莱斯","魔术酋长","城堡建筑师","黄金哥布尔","水果大战","海派甜心","必胜","派对鱼","天王星","珠宝大盗","蝎子","财神","玫瑰之戒","大熊猫","失落的国度","传说奥林巴斯","企鹅家族","金字塔的财富","宁静","伴娘","亚洲美人","纯银","橄榄球明星","黄金时代","篮球巨星","怪兽多多","寿司多多","糖果多多","快乐假日","幸运的锦鲤","舞龙","比基尼派对","太阳征程","东方珍兽","黑绵羊咩咩叫5轴","秘密崇拜者","三國","挥金如土","幸运的小妖精","爱丽娜","搏击怪物","哈维斯的晚餐","现金之王","圣诞之掌","忍者法宝","漂亮猫咪","射击","雷电歌后","开心点心","旋转大战","财炮连连","K歌乐韵","急冻钻石","猴子基诺","丛林吉姆-黄金国","迷失拉斯维加斯","上海美人","幸运龙宝贝","泰山","跑起来","轩辕帝传","富裕人生","不朽情缘/不朽的浪漫","秘密爱慕者","水果VS糖果","经典243","青龙出海","黄金公主","花粉之国","热力四射","板球明星","运财酷儿-5卷轴","幸运双星","复古卷轴-极热","复古旋转","押韵的卷轴-心挞","巨额现金乘数","禁忌王座","金库甜心","梦果子乐园","酷狼","双重韦密","美丽骷髅","地狱男爵","侏罗纪世界","杂技群英会","糖果巡游","108好汉","表情金币","呼撸撸爱上乡下","财运疯狂","疯狂变色龙","黄金囊地鼠","探索太阳","靶心","红衣女郎","怪兽曼琪肯","卷行使价","复古卷轴钻石耀眼","幸运生肖","108好汉乘数财富","寻访海豚","花花公子","妹妹很饿","矮木头","好日子","太阳神之许珀里翁","太阳神之忒伊亚","万圣劫","怪物赛车","星尘","白鲸记","歌剧魅影","躲猫猫","美女枪手丛林激战","5卷的驱动器","燃尼巨蟒","女巫的财富","赢得向导","野生冠军","白水牛","野生捕鱼","财富转轮特别版","亚里尸乐园","地球生物","财富转轮","瓜分大奖","西部边境","北极特务","极寒鸿运","芥末寿司","维多利亚的恶棍","野性的狼群","阿瓦隆2","狂野之鹰","野性的孟加拉虎","美国轮盘","棒棒乌龟","三人德州扑克","三魔法","三角","图腾宝藏","熊虎之战","虎月","埃及王座","百家乐","百家乐黄金版","太空堡垒","大象之王","时空英豪","圣诞企鹅","圣诞老人的百搭摩拖车","小气财神","黑胶热舞","囧囧熊猫","押韵的卷轴-乔治波尔吉","冲浪度假","液体黄金","黄金工厂","持枪王者","宝石探秘财富加倍","巨款大冲击","水果大爆发","宝贝财神","宝石奥德赛","抢劫银行","黄金花花公子","梦幻邂逅","钻石帝国","进击的猿人","巨人财富","古墓丽影秘密之剑","酷犬酒店","海滨财富","派对岛","征服钱海","百搭圣甲虫","财富之都","大逃杀","现金咖啡","雪伍德的罗宾汉","德科钻石","异域狂兽","热血羽球","凯蒂卡巴拉","黑暗故事神秘深红","海豚海岸","足球明星","富贵王国","罗曼诺夫财富","摔角传奇","真正高手","水晶裂谷","Oz之书","秘密行动雪诺和塞布尔","对决沙龙","有你的校园"};
    private static String[] gameNameList = {"28242","28246","28248","28266","28268","28272","28278","28286","28288","28312","28314","28318","28322","28330","28338","28342","28352","28354","28356","28364","28366","28370","28372","28378","28384","28392","28400","28406","28408","28418","28420","28428","28430","28432","28434","28436","28438","28440","28442","28446","28448","28474","28476","28478","28480","28482","28490","28496","28498","28502","28504","28506","28508","28510","28518","28522","28524","28526","28528","28530","28534","28540","28542","28544","28550","28552","28554","28556","28558","28560","28564","28566","28568","28570","28572","28574","28578","28582","28584","28588","28590","28594","28596","28598","28602","28604","28608","28612","28614","28616","28618","28624","28628","28632","28636","28640","28642","28646","28650","28652","28654","28658","28660","28674","28676","28680","28682","28688","28692","28696","28698","28700","28702","28704","28706","28708","28712","28714","28720","28722","28724","28726","28730","28732","28736","28740","28742","28744","28748","28750","28756","28758","28760","28764","28768","28774","28778","28780","28782","28784","28786","28792","28796","28802","28814","28816","28818","28824","28828","28832","28842","28874","28890","28904","28910","28912","28916","28936","28940","28944","28946","28948","28950","28952","28956","28970","28984","29014","29016","29018","29026","29050","29058","29074","29080","29118","29126","29132","29136","29138","29449","29450","29451","29452","29453","29454","29591","29601","35169","35195","35213","36087","37423","39967","40305","42015","42037","42235","42249","42433","42605","42609","42615","42619","42983","43219","43221","43223","43225","45399","45529","45531","45533","45535","45537","45539","45541","45543","45545","45609","45611","46704","46810","50191","50192","55007","57955","59067","59219","59221","60167","60749","60805","60979","60985","61149","61151","61153","61497","61501","61557","65227","66078","66082","66084","66605","66916","66918","67415","67723","68319","68622","68623","68624","69000","69002","69004","69660","69662","69664","69952","70123","70143","70221","70223","70225","70227","70303","70305","70307","70313","70349","70379","70527","70529","70656","70697","70707","70715","70784","70790","70794","70796","70798","70800","70836","70840","70844","70846","70848","70850","70868","70876","70878","70883","70885","70893","70895","70897","70919","70921","71043","71045","71175","71273","71275","28118","28124","28126","28130","28132","28140","28142","28146","28148","28154","28156","28158","28160","28162","28166","28168","28176","28190","28198","28200","28202","28204","28206","28208","28210","28212","28214","28222","28224","28230","28234","28236","28240","71283","71334","71336","71338","71340","71342","71344","71368","71386","71404","71406","71408","71416","71424","71430","71444","71450","71476","71490","71509","71525","71541","71559","71567","71571","71575","71582","71588","71594","71596","71627","71669","71671","71799","71851","71853","71855","71881","71890","71904","71915","71921","71925","71943","71947","71978","71982","71986","72000"};

    public static void main(String[] args) {
        String path = "G:\\XFProject\\WG电子图片\\imgPC\\MG";
        for (int i = 0; i < showNameList.length; i++) {
            boolean flag = rename(new File(path+"\\"+showNameList[i]+".png"), gameNameList[i]+".png");
            if(!flag){
                System.out.println(gameNameList[i]);
            }
        }
    }

    /**
     * Rename the file.
     */
    public static boolean rename(final File file, final String newName) {
        // file is null then return false
        if (file == null) return false;
        // file doesn't exist then return false
        if (!file.exists()) return false;
        // the new name is space then return false
        if (newName == "" || null == newName) return false;
        // the new name equals old name then return true
        if (newName.equals(file.getName())) return true;
        File newFile = new File(file.getParent() + File.separator + newName);
        // the new name of file exists then return false
        return !newFile.exists()
                && file.renameTo(newFile);
    }

}