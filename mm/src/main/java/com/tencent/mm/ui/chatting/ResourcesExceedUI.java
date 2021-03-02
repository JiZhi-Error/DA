package com.tencent.mm.ui.chatting;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tavkit.component.TAVExporter;

public class ResourcesExceedUI extends MMActivity {
    private TextView Pkf;
    private int type = 0;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(34869);
        customfixStatusbar(true);
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        getWindow().getDecorView().setSystemUiVisibility(TAVExporter.VIDEO_EXPORT_HEIGHT);
        this.type = getIntent().getIntExtra("clean_view_type", 0);
        setMMTitle("");
        initView();
        AppMethodBeat.o(34869);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(34870);
        hideTitleView();
        fullScreenNoTitleBar(true);
        if (d.oD(19)) {
            getWindow().setFlags(201327616, 201327616);
        } else {
            getWindow().setFlags(1024, 1024);
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.chatting.ResourcesExceedUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(34867);
                ResourcesExceedUI.this.finish();
                AppMethodBeat.o(34867);
                return true;
            }
        });
        this.Pkf = (TextView) findViewById(R.id.btz);
        switch (this.type) {
            case 0:
                this.Pkf.setText(R.string.hwo);
                break;
            case 1:
                this.Pkf.setText(R.string.e35);
                break;
            case 2:
                this.Pkf.setText(R.string.ce2);
                break;
        }
        findViewById(R.id.h9a).setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.ui.chatting.ResourcesExceedUI.AnonymousClass2 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(34868);
                ResourcesExceedUI.this.finish();
                AppMethodBeat.o(34868);
                return false;
            }
        });
        AppMethodBeat.o(34870);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bn8;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(34871);
        super.onDestroy();
        AppMethodBeat.o(34871);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(34872);
        super.finish();
        overridePendingTransition(0, 0);
        AppMethodBeat.o(34872);
    }
}
