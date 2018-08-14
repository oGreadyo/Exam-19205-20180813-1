github链接：https://github.com/oGreadyo/Exam-19205-20180813-1.git
部署项目到tomcat上并运行，index.jsp页面为


整个系统主要使用了sevlet+jsp来完成，整个系统的功能已经全部完成，测试无bug。

1.系统运行初始界面-index.jsp登录要页面
    用户名输入账号密码登入系统。

![avatar](https://github.com/oGreadyo/Exam-19205-20180813-1/blob/master/pic/1.PNG)

    1.1错误用户名登录失败测试

![avatar](https://github.com/oGreadyo/Exam-19205-20180813-1/blob/master/pic/2.PNG)

   最后登录出错。

    1.2没有登录输入URL进入到电影的主界面-Home.jsp

![avatar](https://github.com/oGreadyo/Exam-19205-20180813-1/blob/master/pic/3.PNG)


    无法进入到Home.jsp页面下，会提示登录操作。

    1.3 用户名密码正确登录

![avatar](https://github.com/oGreadyo/Exam-19205-20180813-1/raw/master/pic/4.PNG)

    显示登录成功，点击确定后进入到Home.jsp页面。
    Home.jsp页面主要为显示电影信息，添加电影和搜索电影的主要功能。中间是一个轮播图。

![avatar](https://github.com/oGreadyo/Exam-19205-20180813-1/raw/master/pic/5.PNG)

    下面是系统数据库中电影信息的显示，这里自己以前做过电影推荐系统的一个web项目，所以直接把以前工程的
电影文件和图片拿过来了，这样显示在系统中更真实些。

![avatar](https://github.com/oGreadyo/Exam-19205-20180813-1/raw/master/pic/6.PNG)

2、增删改查功能
   2.1增-添加一个电影
    点击右上角的添加电影按钮，页面跳转到AddFilm.jsp
![avatar](https://github.com/oGreadyo/Exam-19205-20180813-1/raw/master/pic/7PNG)
    
    进入AddFilm.jsp

![avatar](https://github.com/oGreadyo/Exam-19205-20180813-1/raw/master/pic/8.PNG)

    当什么都不填写，或者电影名和描述中一个为空，都不能添加成功。

![avatar](https://github.com/oGreadyo/Exam-19205-20180813-1/raw/master/pic/9.PNG)

    正确填写电影名，电影介绍，选择语言。可以不选择语言，当没有选择的时候是没有添加语言。

![avatar](https://github.com/oGreadyo/Exam-19205-20180813-1/raw/master/pic/10.PNG)

    电影添加成功，点击确认回到主界面可以查看到新添加的电影。但是没有对应的图片。

    主界面可以看到刚刚添加的“我不是药神”这部电影。

![avatar](https://github.com/oGreadyo/Exam-19205-20180813-1/raw/master/pic/11.PNG)

  2.2删-删除一个一部电影
     点击页面的一个电影，会进入到电影的详细信息界面FilmDetail.jsp页面。
![avatar](https://github.com/oGreadyo/Exam-19205-20180813-1/raw/master/pic/12.PNG)

    点击删除按钮，会删除该电影，这里删除ID 为1004的电影，删除成功后再主页面就查看不到该电影信息了。

    回到主页面，ID为1004的电影不见了，删除成功。

![avatar](https://github.com/oGreadyo/Exam-19205-20180813-1/raw/master/pic/13.PNG)

  2.3改-修改电影信息
    
     和删除电影一样，点击进入电影详细信息，对相应的信息进行修改，修改完后点击修改按钮。

![avatar](https://github.com/oGreadyo/Exam-19205-20180813-1/raw/master/pic/14.PNG)

    修改ID为1014的电影信息，把电影名换成“888888”，内容换成“test内容修改88888888”，语言本来是没有语言的，
选择Russian，点击修改按钮后查看该电影信息。

    修改成功。

![avatar](https://github.com/oGreadyo/Exam-19205-20180813-1/raw/master/pic/15.PNG)

    再次查看ID为1014的电影信息，可以看到电影信息已经被修改成功了。

![avatar](https://github.com/oGreadyo/Exam-19205-20180813-1/raw/master/pic/16.PNG)

  2.4-查-查找一部电影
     在最上面的搜索框输入电影ID或者电影名，点击搜索查询相应的电影信息。

![avatar](https://github.com/oGreadyo/Exam-19205-20180813-1/raw/master/pic/17.PNG)

    输入电影名Babe，点击搜索按钮，下面会得到搜索的电影信息。

![avatar](https://github.com/oGreadyo/Exam-19205-20180813-1/raw/master/pic/18.PNG)

    输入电影ID “100”，可以查询出电影ID包含“100”的所有电影信息。

![avatar](https://github.com/oGreadyo/Exam-19205-20180813-1/raw/master/pic/19.PNG)

    得到的查询结果如下。

![avatar](https://github.com/oGreadyo/Exam-19205-20180813-1/raw/master/pic/20.PNG)

  总结：
      整个系统的所有功能都已完成，但是系统还有欠缺的地方，比如修改电影信息还可以加上修改电影图片功能，
由于时间的原因没有继续完成。
