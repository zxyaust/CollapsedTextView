package z.collapsedtextview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import z.collapsedtextviewlibrary.CollapsedTextView;

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
