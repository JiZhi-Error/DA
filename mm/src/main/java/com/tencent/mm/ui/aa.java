package com.tencent.mm.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.ui.widget.MMCollapsibleTextView;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.cedit.api.c;

public final class aa {
    public static final int[] OHJ = {16843087, 16843088, 16843379};
    public static final int[] OHK = {16843379};

    /* access modifiers changed from: package-private */
    public static final class a implements LayoutInflater.Factory {
        LayoutInflater layoutInflater;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        private View createView(String str, String str2, AttributeSet attributeSet) {
            AppMethodBeat.i(141464);
            View view = null;
            try {
                view = this.layoutInflater.createView(str, str2, attributeSet);
            } catch (InflateException | ClassNotFoundException e2) {
            }
            AppMethodBeat.o(141464);
            return view;
        }

        public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
            float f2;
            View view = null;
            AppMethodBeat.i(141463);
            try {
                if (str.indexOf(".") == -1) {
                    View createView = str.equals("WebView") ? createView(str, "android.webkit.", attributeSet) : null;
                    if (createView == null) {
                        createView = createView(str, "android.widget.", attributeSet);
                    }
                    if (createView == null) {
                        view = createView(str, "android.view.", attributeSet);
                    } else {
                        view = createView;
                    }
                } else {
                    view = this.layoutInflater.createView(str, null, attributeSet);
                }
                if ((view instanceof ViewStub) && Build.VERSION.SDK_INT >= 21) {
                    ((ViewStub) view).setLayoutInflater(this.layoutInflater);
                }
                if (view == null) {
                    Log.w("MicroMsg.MMLayoutInflater", "Inflate view, ClassNotFound ".concat(String.valueOf(str)));
                } else if (str.equals("TextView") || str.equals("Button") || str.equals("EditText") || str.equals("CheckBox") || str.equals("ImageView") || str.equals("CheckedTextView") || str.equals("com.tencent.mm.ui.widget.MMTextView") || str.equals("com.tencent.mm.ui.widget.MMEditText") || str.equals("com.tencent.mm.ui.widget.MMNeat7extView") || str.equals("com.tencent.mm.ui.widget.MMCollapsibleTextView") || str.equals("com.tencent.mm.ui.base.MMClearEditText") || str.equals("com.tencent.mm.ui.widget.edittext.PasterEditText") || str.equals("com.tenpay.android.wechat.TenpaySecureEditText") || str.equals("com.tencent.mm.ui.base.MMVisiblePasswordEditText") || str.equals("com.tencent.mm.ui.tools.MMTruncTextView") || str.equals("com.tencent.mm.plugin.brandservice.ui.base.CatalogView") || str.equals("com.tencent.mm.ui.tools.CustomFitTextView") || str.equals("com.tencent.mm.ui.tools.ActionBarSearchView$ActionBarEditText") || str.equals("com.tencent.mm.plugin.favorite.ui.base.FavDetailFooterView") || str.equals("com.tencent.mm.plugin.game.ui.GameDropdownView") || str.equals("com.tencent.mm.ui.ScrollAlwaysTextView") || str.equals("com.tencent.mm.ui.base.MMAutoSizeTextView") || str.equals("com.tencent.mm.ui.widget.textview.MMAutoAdjustTextView") || str.equals("com.tencent.mm.plugin.sns.ui.AsyncTextView") || str.equals("com.tencent.mm.plugin.sns.ui.SnsTextView") || str.equals("com.tencent.mm.plugin.sns.ui.MaskTextView") || str.equals("com.tencent.mm.plugin.sns.ui.SnsEditText") || str.equals("com.tencent.mm.kiss.widget.textview.PLSysTextView") || str.equals("com.tencent.mm.ui.base.EllipsizeTextView") || str.equals("com.tencent.mm.wallet_core.ui.WalletTextView") || str.equals("com.tencent.mm.ui.widget.cedit.api.MMCustomEditText") || str.equals("com.tencent.mm.plugin.sns.ui.SnsCustomEditText") || str.equals("com.tencent.mm.ui.widget.cedit.api.MMFlexEditText")) {
                    float ez = com.tencent.mm.cb.a.ez(context);
                    if (context.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getBoolean("screenResolution_isModifyDensity", true) && (ao.as(ez, 1.1f) || ao.as(ez, 0.8f))) {
                        ez = 1.0f;
                    }
                    if ((ao.as(ez, com.tencent.mm.cb.a.jc(context)) || ao.as(ez, com.tencent.mm.cb.a.jd(context))) && !str.equals("com.tencent.mm.ui.widget.MMTextView") && !str.equals("com.tencent.mm.plugin.sns.ui.AsyncTextView") && !str.equals("com.tencent.mm.plugin.sns.ui.SnsTextView") && !str.equals("com.tencent.mm.plugin.sns.ui.MaskTextView") && !str.equals("com.tencent.mm.ui.widget.MMNeat7extView") && !str.equals("com.tencent.mm.ui.widget.cedit.api.MMCustomEditText") && !str.equals("com.tencent.mm.plugin.sns.ui.SnsCustomEditText") && !str.equals("com.tencent.mm.ui.widget.cedit.api.MMFlexEditText") && !str.equals("com.tencent.mm.ui.widget.MMCollapsibleTextView")) {
                        f2 = com.tencent.mm.cb.a.jb(context);
                    } else {
                        f2 = ez;
                    }
                    if (str.equals("TextView") || str.equals("com.tencent.mm.ui.widget.MMTextView") || str.equals("com.tencent.mm.wallet_core.ui.WalletTextView") || str.equals("com.tencent.mm.ui.widget.textview.MMAutoAdjustTextView")) {
                        TextView textView = (TextView) view;
                        textView.setTextSize(1, (f2 * textView.getTextSize()) / com.tencent.mm.cb.a.getDensity(textView.getContext()));
                        context.getAssets();
                        h.gvF();
                        if (h.gvG()) {
                            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, aa.OHJ);
                            for (int i2 = 0; i2 < aa.OHJ.length; i2++) {
                                int resourceId = obtainStyledAttributes.getResourceId(i2, 0);
                                if (resourceId != 0) {
                                    if (aa.OHJ[i2] == 16843379) {
                                        textView.setContentDescription(context.getString(resourceId));
                                    } else if (aa.OHJ[i2] == 16843088) {
                                        textView.setHint(context.getString(resourceId));
                                    } else {
                                        textView.setText(context.getString(resourceId));
                                    }
                                }
                            }
                            obtainStyledAttributes.recycle();
                        }
                        b.D(textView);
                    } else if (str.equals("Button")) {
                        Button button = (Button) view;
                        button.setTextSize(1, (f2 * button.getTextSize()) / com.tencent.mm.cb.a.getDensity(button.getContext()));
                        context.getAssets();
                        h.gvF();
                        if (h.gvG()) {
                            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, aa.OHJ);
                            for (int i3 = 0; i3 < aa.OHJ.length; i3++) {
                                int resourceId2 = obtainStyledAttributes2.getResourceId(i3, 0);
                                if (resourceId2 != 0) {
                                    if (aa.OHJ[i3] == 16843379) {
                                        button.setContentDescription(context.getString(resourceId2));
                                    } else if (aa.OHJ[i3] == 16843088) {
                                        button.setHint(context.getString(resourceId2));
                                    } else {
                                        button.setText(context.getString(resourceId2));
                                    }
                                }
                            }
                            obtainStyledAttributes2.recycle();
                        }
                        b.D(button);
                    } else if (str.equals("EditText") || str.equals("com.tencent.mm.ui.widget.MMEditText") || str.equals("com.tencent.mm.ui.base.MMClearEditText") || str.equals("com.tencent.mm.ui.widget.edittext.PasterEditText") || str.equals("com.tencent.mm.ui.tools.ActionBarSearchView$ActionBarEditText") || str.equals("com.tenpay.android.wechat.TenpaySecureEditText") || str.equals("com.tencent.mm.ui.base.MMVisiblePasswordEditText") || str.equals("com.tencent.mm.plugin.sns.ui.SnsEditText")) {
                        EditText editText = (EditText) view;
                        editText.setTextSize(1, (f2 * editText.getTextSize()) / com.tencent.mm.cb.a.getDensity(editText.getContext()));
                        context.getAssets();
                        h.gvF();
                        if (h.gvG()) {
                            TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, aa.OHJ);
                            for (int i4 = 0; i4 < aa.OHJ.length; i4++) {
                                int resourceId3 = obtainStyledAttributes3.getResourceId(i4, 0);
                                if (resourceId3 != 0) {
                                    if (aa.OHJ[i4] == 16843379) {
                                        editText.setContentDescription(context.getString(resourceId3));
                                    } else if (aa.OHJ[i4] == 16843088) {
                                        editText.setHint(context.getString(resourceId3));
                                    } else {
                                        editText.setText(context.getString(resourceId3));
                                    }
                                }
                            }
                            obtainStyledAttributes3.recycle();
                        }
                        b.D(editText);
                    } else if (str.equals("com.tencent.mm.ui.widget.cedit.api.MMCustomEditText") || str.equals("com.tencent.mm.plugin.sns.ui.SnsCustomEditText") || str.equals("com.tencent.mm.ui.widget.cedit.api.MMFlexEditText")) {
                        c cVar = (c) view;
                        cVar.setTextSize(1, (f2 * cVar.getTextSize()) / com.tencent.mm.cb.a.getDensity(cVar.gYK()));
                        context.getAssets();
                        h.gvF();
                        if (h.gvG()) {
                            TypedArray obtainStyledAttributes4 = context.obtainStyledAttributes(attributeSet, aa.OHJ);
                            for (int i5 = 0; i5 < aa.OHJ.length; i5++) {
                                int resourceId4 = obtainStyledAttributes4.getResourceId(i5, 0);
                                if (resourceId4 != 0) {
                                    if (aa.OHJ[i5] == 16843379) {
                                        cVar.setContentDescription(context.getString(resourceId4));
                                    } else if (aa.OHJ[i5] == 16843088) {
                                        cVar.setHint(context.getString(resourceId4));
                                    } else {
                                        cVar.setText(context.getString(resourceId4));
                                    }
                                }
                            }
                            obtainStyledAttributes4.recycle();
                        }
                        Editable text = cVar.getText();
                        if (!TextUtils.isEmpty(text)) {
                            cVar.setText(b.aq(text));
                        }
                        CharSequence hint = cVar.getHint();
                        if (!TextUtils.isEmpty(hint)) {
                            cVar.setHint(b.aq(hint));
                        }
                        CharSequence contentDescription = cVar.getContentDescription();
                        if (!TextUtils.isEmpty(contentDescription)) {
                            cVar.setContentDescription(b.aq(contentDescription));
                        }
                    } else if (str.equals("CheckBox")) {
                        CheckBox checkBox = (CheckBox) view;
                        checkBox.setTextSize(1, (f2 * checkBox.getTextSize()) / com.tencent.mm.cb.a.getDensity(checkBox.getContext()));
                        context.getAssets();
                        h.gvF();
                        if (h.gvG()) {
                            TypedArray obtainStyledAttributes5 = context.obtainStyledAttributes(attributeSet, aa.OHJ);
                            for (int i6 = 0; i6 < aa.OHJ.length; i6++) {
                                int resourceId5 = obtainStyledAttributes5.getResourceId(i6, 0);
                                if (resourceId5 != 0) {
                                    if (aa.OHJ[i6] == 16843379) {
                                        checkBox.setContentDescription(context.getString(resourceId5));
                                    } else if (aa.OHJ[i6] == 16843088) {
                                        checkBox.setHint(context.getString(resourceId5));
                                    } else {
                                        checkBox.setText(context.getString(resourceId5));
                                    }
                                }
                            }
                            obtainStyledAttributes5.recycle();
                        }
                        b.D(checkBox);
                    } else if (str.equals("ImageView")) {
                        ImageView imageView = (ImageView) view;
                        context.getAssets();
                        h.gvF();
                        if (h.gvG()) {
                            TypedArray obtainStyledAttributes6 = context.obtainStyledAttributes(attributeSet, aa.OHK);
                            for (int i7 = 0; i7 < aa.OHK.length; i7++) {
                                int resourceId6 = obtainStyledAttributes6.getResourceId(i7, 0);
                                if (resourceId6 != 0 && aa.OHK[i7] == 16843379) {
                                    imageView.setContentDescription(context.getString(resourceId6));
                                }
                            }
                            obtainStyledAttributes6.recycle();
                        }
                        CharSequence contentDescription2 = imageView.getContentDescription();
                        if (!TextUtils.isEmpty(contentDescription2)) {
                            imageView.setContentDescription(b.aq(contentDescription2));
                        }
                    } else if (str.equals("com.tencent.mm.ui.widget.MMNeat7extView")) {
                        MMNeat7extView mMNeat7extView = (MMNeat7extView) view;
                        mMNeat7extView.setTextSize(1, (f2 * mMNeat7extView.getTextSize()) / com.tencent.mm.cb.a.getDensity(mMNeat7extView.getContext()));
                        CharSequence hiT = mMNeat7extView.hiT();
                        if (!TextUtils.isEmpty(hiT)) {
                            mMNeat7extView.aw(b.aq(hiT));
                        }
                        CharSequence hint2 = mMNeat7extView.getHint();
                        if (!TextUtils.isEmpty(hint2)) {
                            mMNeat7extView.setHint(b.aq(hint2));
                        }
                        CharSequence contentDescription3 = mMNeat7extView.getContentDescription();
                        if (!TextUtils.isEmpty(contentDescription3)) {
                            mMNeat7extView.setContentDescription(b.aq(contentDescription3));
                        }
                    } else if (str.equals("com.tencent.mm.ui.widget.MMCollapsibleTextView")) {
                        MMCollapsibleTextView mMCollapsibleTextView = (MMCollapsibleTextView) view;
                        float textSize = (f2 * mMCollapsibleTextView.getTextSize()) / com.tencent.mm.cb.a.getDensity(mMCollapsibleTextView.getContext());
                        mMCollapsibleTextView.get_collapseButton().setTextSize(1, textSize);
                        mMCollapsibleTextView.get_contentText().setTextSize(1, textSize);
                        mMCollapsibleTextView.get_contentBackupText().setTextSize(1, textSize);
                    } else if (view instanceof TextView) {
                        TextView textView2 = (TextView) view;
                        textView2.setTextSize(1, (f2 * textView2.getTextSize()) / com.tencent.mm.cb.a.getDensity(textView2.getContext()));
                        b.D(textView2);
                    }
                }
            } catch (ClassNotFoundException e2) {
                Log.w("MicroMsg.MMLayoutInflater", "[cpan] class not found. name:%s. Use default Inflate.", str);
            } catch (InflateException e3) {
                Log.w("MicroMsg.MMLayoutInflater", "[cpan] Inflate failed. name:%s. Use default Inflate.", str);
            }
            AppMethodBeat.o(141463);
            return view;
        }
    }

    static final class b {
        public static void D(TextView textView) {
            AppMethodBeat.i(205127);
            CharSequence text = textView.getText();
            if (!TextUtils.isEmpty(text)) {
                textView.setText(aq(text));
            }
            CharSequence hint = textView.getHint();
            if (!TextUtils.isEmpty(hint)) {
                textView.setHint(aq(hint));
            }
            CharSequence contentDescription = textView.getContentDescription();
            if (!TextUtils.isEmpty(contentDescription)) {
                textView.setContentDescription(aq(contentDescription));
            }
            AppMethodBeat.o(205127);
        }

        static String aq(CharSequence charSequence) {
            AppMethodBeat.i(205128);
            if (charSequence == null) {
                AppMethodBeat.o(205128);
                return null;
            }
            String blT = blT(charSequence.toString());
            AppMethodBeat.o(205128);
            return blT;
        }

        private static String blT(String str) {
            AppMethodBeat.i(205129);
            if (TextUtils.isEmpty(str)) {
                AppMethodBeat.o(205129);
                return str;
            }
            String translate = WeChatBrands.Wordings.translate(str);
            AppMethodBeat.o(205129);
            return translate;
        }
    }

    public static LayoutInflater b(LayoutInflater layoutInflater) {
        AppMethodBeat.i(141465);
        com.tencent.mm.cb.a.ez(layoutInflater.getContext());
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(layoutInflater.getContext());
        a aVar = new a((byte) 0);
        aVar.layoutInflater = cloneInContext;
        cloneInContext.setFactory(aVar);
        AppMethodBeat.o(141465);
        return cloneInContext;
    }

    public static LayoutInflater jQ(Context context) {
        AppMethodBeat.i(141466);
        com.tencent.mm.cb.a.ez(context);
        LayoutInflater cloneInContext = LayoutInflater.from(context).cloneInContext(context);
        a aVar = new a((byte) 0);
        aVar.layoutInflater = cloneInContext;
        cloneInContext.setFactory(aVar);
        AppMethodBeat.o(141466);
        return cloneInContext;
    }
}
