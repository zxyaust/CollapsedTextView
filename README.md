# CollapsedTextView

可折叠的textview,支持重新设置text内容之后还能折叠

![更改text内容之后依旧可以折叠展开][1]
# 使用方法
添加依赖,或者eclipse中依赖此library,或者直接下载CollapsedTextView.java文件放在自己的项目中即可
jcenter地址:
```
compile 'com.z:CollapsedTextView:1.0.0'
```
##布局中,其中maxLines就是最大行数,超过这个行数就会折叠起来,
```
 <z.collapsedtextviewlibrary.CollapsedTextView
        android:id="@+id/tv"
        android:layout_width="50dp"
        android:layout_height="wrap_content"
        android:maxLines="6"
        android:text="!Hello World!Hello World!Herld!" />
```
##主要方法:
###1.public boolean isNeedCollapse()是否需要折叠,如果文本实际行数小于你设置的要折叠的阈值,那么就返回false,即不需要折叠,否则返回true
###2.public void collapse()折叠方法,textview折叠时,调用此方法展开,展开时调用此方法折叠
###3.public boolean isCollapsed成员变量,是否已折叠,随时可以调用,获取折叠状态
##在activity使用示例

```
public class MainActivity extends AppCompatActivity {

    private Button mBtButton;
    private CollapsedTextView mTvCollapsedTextView;
    private Button mBt1Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtButton = (Button) findViewById(R.id.bt);
        mBt1Button = (Button) findViewById(R.id.bt1);
        mTvCollapsedTextView = (CollapsedTextView) findViewById(R.id.tv);
        mBt1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvCollapsedTextView.setText("123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789");
                if (!mTvCollapsedTextView.isNeedCollapse()) { //如果不需要折叠,button就隐藏
                    mBtButton.setVisibility(View.VISIBLE);
                    mBtButton.setText("展开");
                }
            }
        });
        if (!mTvCollapsedTextView.isNeedCollapse()) //如果不需要折叠,button就隐藏
            mBtButton.setVisibility(View.GONE);
        mBtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean collapsed = mTvCollapsedTextView.isCollapsed;
                if (collapsed) {//如果折叠了,就展开
                    mTvCollapsedTextView.collapse();
                    mBtButton.setText("折叠");
                } else {//如果没折叠,就折叠
                    mTvCollapsedTextView.collapse();
                    mBtButton.setText("展开");
                }
            }
        });

    }

}
```


  [1]: https://github.com/zxyaust/CollapsedTextView/blob/master/SCR_20160718_170645.gif?raw=true