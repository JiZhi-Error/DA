package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.wallet_core.ui.f;
import java.util.ArrayList;

public abstract class BaseKindaCodeView extends MMKView<ImageView> {
    private ArrayList<Bitmap> mCodeBitmaps;
    private String mCodeStringValue;
    protected Context mContext;
    private ImageView mIvCodeView;

    /* access modifiers changed from: protected */
    public abstract Bitmap getNewBitmap(String str);

    @Override // com.tencent.kinda.framework.widget.base.MMKView
    public ImageView createView(Context context) {
        this.mContext = context;
        this.mIvCodeView = new ImageView(context);
        this.mIvCodeView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.mCodeBitmaps = new ArrayList<>();
        return this.mIvCodeView;
    }

    public void setCode(String str) {
        this.mCodeStringValue = str;
        Bitmap newBitmap = getNewBitmap(str);
        this.mIvCodeView.setImageBitmap(newBitmap);
        recycleBmpList();
        this.mCodeBitmaps.add(newBitmap);
    }

    public String getCode() {
        return this.mCodeStringValue;
    }

    private void recycleBmpList() {
        if (this.mCodeBitmaps.size() >= 2) {
            for (int size = this.mCodeBitmaps.size() - 1; size > 1; size--) {
                f.Z(this.mCodeBitmaps.remove(size));
            }
        }
    }
}
