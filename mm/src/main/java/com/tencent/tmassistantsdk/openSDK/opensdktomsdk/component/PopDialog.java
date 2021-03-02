package com.tencent.tmassistantsdk.openSDK.opensdktomsdk.component;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.i;
import com.tencent.tmassistantsdk.openSDK.opensdktomsdk.data.ActionButton;
import com.tencent.tmassistantsdk.util.Res;
import com.tencent.tmassistantsdk.util.TMLog;

public class PopDialog extends i {
    public static final int DIALOG_STYLE_MUL_BTN = 2;
    public static final int DIALOG_STYLE_SINGLE_BTN = 1;
    protected static final String TAG = "PopDialog";
    protected RelativeLayout contentLayout = null;
    protected TextView contentView = null;
    public ProgressBar downloadProgressBar = null;
    public TextView downloadText = null;
    protected Context mContext = null;
    private Button negativeBtn = null;
    protected Button positiveBtn = null;
    protected FrameLayout positiveLayout = null;
    public Res rTool = null;
    protected int style = 0;
    protected TextView titleView = null;

    public PopDialog(Context context) {
        super(context);
        this.mContext = context;
    }

    public PopDialog(Context context, int i2) {
        super(context, i2);
        this.mContext = context;
    }

    public PopDialog(Context context, int i2, int i3) {
        super(context, i2);
        this.mContext = context;
        this.style = i3;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(102200);
        super.onCreate(bundle);
        this.rTool = new Res(this.mContext);
        super.setContentView(this.rTool.layout("com_tencent_tmassistant_sdk_white_list_dlg"));
        super.getWindow().setLayout(px(662), px(662));
        setCancelable(false);
        this.titleView = (TextView) findViewById(this.rTool.id("dlg_title_tv"));
        this.contentLayout = (RelativeLayout) findViewById(this.rTool.id("content"));
        this.contentView = (TextView) findViewById(this.rTool.id("dlg_body_tv"));
        this.positiveBtn = (Button) findViewById(this.rTool.id("positive_btn"));
        this.positiveLayout = (FrameLayout) findViewById(this.rTool.id("positive_btn_frame_layout"));
        this.downloadProgressBar = (ProgressBar) findViewById(this.rTool.id("download_pb"));
        this.downloadText = (TextView) findViewById(this.rTool.id("progress_txt_tv"));
        this.negativeBtn = (Button) findViewById(this.rTool.id("negtive_btn"));
        relayoutView();
        AppMethodBeat.o(102200);
    }

    private void relayoutView() {
        AppMethodBeat.i(102201);
        initHeaderView();
        switch (this.style) {
            case 1:
                initSingleDialog();
                AppMethodBeat.o(102201);
                return;
            case 2:
                initMulDialog();
                break;
        }
        AppMethodBeat.o(102201);
    }

    private void initHeaderView() {
        AppMethodBeat.i(102202);
        this.titleView.setPadding(px(30), 0, px(30), 0);
        this.contentLayout.setPadding(px(30), 0, px(30), px(30));
        this.contentView.setPadding(0, px(30), 0, px(30));
        AppMethodBeat.o(102202);
    }

    private void initSingleDialog() {
        AppMethodBeat.i(102203);
        this.positiveLayout.setVisibility(8);
        this.negativeBtn.setHeight(px(78));
        this.negativeBtn.setText(this.mContext.getString(this.rTool.string("white_list_submit")));
        AppMethodBeat.o(102203);
    }

    private void initMulDialog() {
        AppMethodBeat.i(102204);
        this.negativeBtn.setHeight(px(78));
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.negativeBtn.getLayoutParams();
        marginLayoutParams.setMargins(0, 0, px(30), 0);
        this.negativeBtn.setLayoutParams(marginLayoutParams);
        this.positiveBtn.setHeight(px(78));
        this.positiveBtn.setTextSize((float) px(30));
        this.downloadProgressBar.setMinimumHeight(px(78));
        this.downloadText.setHeight(px(78));
        AppMethodBeat.o(102204);
    }

    public void setTitle(String str) {
        AppMethodBeat.i(102205);
        if (!TextUtils.isEmpty(str)) {
            this.titleView.setText(str);
        }
        AppMethodBeat.o(102205);
    }

    public void setContent(String str) {
        AppMethodBeat.i(102206);
        if (!TextUtils.isEmpty(str)) {
            this.contentView.setText(str);
        }
        AppMethodBeat.o(102206);
    }

    public void setPositiveBtnTag(ActionButton actionButton) {
        AppMethodBeat.i(102207);
        if (actionButton != null) {
            this.positiveBtn.setTag(actionButton);
        }
        AppMethodBeat.o(102207);
    }

    public void setPositiveBtnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(102208);
        if (onClickListener != null) {
            this.positiveBtn.setOnClickListener(onClickListener);
        }
        AppMethodBeat.o(102208);
    }

    public void setPositiveBtnText(String str) {
        AppMethodBeat.i(102209);
        if (!TextUtils.isEmpty(str)) {
            this.downloadText.setText(str);
        }
        AppMethodBeat.o(102209);
    }

    public void setPositiveBtnBgResource(int i2) {
        AppMethodBeat.i(102210);
        if (i2 != 0) {
            this.positiveBtn.setBackgroundResource(i2);
        }
        AppMethodBeat.o(102210);
    }

    public void setPositiveBtnEnable(boolean z) {
        AppMethodBeat.i(102211);
        if (this.positiveBtn != null) {
            this.positiveBtn.setEnabled(z);
        }
        AppMethodBeat.o(102211);
    }

    public void setNegativeBtnText(String str) {
        AppMethodBeat.i(102212);
        if (!TextUtils.isEmpty(str)) {
            this.negativeBtn.setText(str);
        }
        AppMethodBeat.o(102212);
    }

    public void setNegativeBtnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(102213);
        if (onClickListener != null) {
            this.negativeBtn.setOnClickListener(onClickListener);
        }
        AppMethodBeat.o(102213);
    }

    public int getScreenWidth() {
        AppMethodBeat.i(102214);
        if (this.mContext != null) {
            int i2 = this.mContext.getResources().getDisplayMetrics().widthPixels;
            AppMethodBeat.o(102214);
            return i2;
        }
        AppMethodBeat.o(102214);
        return 0;
    }

    public int getScreenHeight() {
        AppMethodBeat.i(102215);
        if (this.mContext != null) {
            int i2 = this.mContext.getResources().getDisplayMetrics().heightPixels;
            AppMethodBeat.o(102215);
            return i2;
        }
        AppMethodBeat.o(102215);
        return 0;
    }

    private int px(int i2) {
        AppMethodBeat.i(102216);
        int screenHeight = getScreenHeight();
        int screenWidth = getScreenWidth();
        TMLog.i(TAG, " width = " + screenWidth + "  height = " + screenHeight);
        if (screenHeight <= screenWidth) {
            screenHeight = screenWidth;
        }
        int i3 = (int) (((((float) screenHeight) + 0.0f) * ((float) i2)) / 1280.0f);
        TMLog.i(TAG, "rtn" + i2 + ":" + i3);
        AppMethodBeat.o(102216);
        return i3;
    }
}
