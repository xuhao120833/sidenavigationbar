package com.example.sidenavigationbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
//引入必须引入对，不然setSupportActionBar会报参数错误,不能引入成 import android.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    //private Button img_menuBtn;
    /**导航栏左侧的侧边栏的父容器*/
    private DrawerLayout mDrawerLayout;
    //导航视图
    private NavigationView mNavigationView;

    //引入toolbar
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initEvents();
    }
    /**
     * 初始化视图
     * */
    private void initViews() {
        // 侧滑视图操作对象
        mDrawerLayout = findViewById(R.id.drawerLayout);
        mNavigationView = findViewById(R.id.nav_view);

        //  toolbar部分
        //  toolbar一个导航控件，设计来用于代替actionbar，actionbar有缺点，只能显示在界面最上边
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);//这句代码是必须的，表示支持用toolbar代替actionbar
        //getSupportActionBar().setHomeButtonEnabled(true); //决定左上角的图标是否可以被点击，默认为true

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true); //该方法是 决定左上角图标的右侧是否有向左的小箭头
        //toolbar左侧的返回键按钮，要么在这里设置成系统默认的返回箭头图标，要么在xml布局文件里面通过app:navigationIcon=
        //引入自定义的返回键图标
        toolbarclick();

        // 侧滑按钮
        //img_menuBtn = findViewById(R.id.img_menuBtn);
        //meunClick();
    }


    /**
     * 侧滑按钮点击事件
     * */
//    private void meunClick(){
//        //用户图标的点击事件
//        img_menuBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mDrawerLayout.openDrawer(Gravity.LEFT);
//            }
//        });
//    }

    /**
     * 侧滑栏点击事件
     * */
    private void initEvents() {

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.menu_info:
                        Toast.makeText(MainActivity.this, "个人信息", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_pwd:
                        Toast.makeText(MainActivity.this, "修改密码", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_setting:
                        Toast.makeText(MainActivity.this, "设置", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_about:
                        Toast.makeText(MainActivity.this, "关于", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_exit:
                        Toast.makeText(MainActivity.this, "退出", Toast.LENGTH_SHORT).show();
                        break;
                }
                //关闭侧滑菜单
                mDrawerLayout.closeDrawers();
                return true;
            }
        });
    }

    //下面是toolbar相关的函数
    //toolbar 返回键点击事件绑定
    private void toolbarclick(){
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //finish();
                //Toast.makeText(MainActivity.this, "返回", Toast.LENGTH_SHORT).show();
                mDrawerLayout.openDrawer(Gravity.LEFT);
                //这里的值必须和xml里侧边栏android:layout_gravity="left" 的值相同，不然app会异常退出
            }
        });
    }

    //溢出菜单创建,和onCreate一样，无需调用，高度封装，应用执行UI线程的时候会自动执行到，只需重写 自己需要的逻辑。
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    //溢出栏菜单点击事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            Toast.makeText(MainActivity.this, "返回", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.toolbar_user) {
            Toast.makeText(MainActivity.this, "用户", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.toolbar_setting) {
            Toast.makeText(MainActivity.this, "设置", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.toolbar_other) {
            Toast.makeText(MainActivity.this, "其他", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}