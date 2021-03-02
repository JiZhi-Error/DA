package com.tencent.mm.plugin.textstatus.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.style.ImageSpan;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.kernel.b.a;
import com.tencent.mm.plugin.textstatus.a.a;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.NoMeasuredTextView;

public interface c extends a {
    CharSequence attachTextStatusSpanSync(String str, CharSequence charSequence, a.b bVar, float f2);

    void clearTextStatus(TextView textView, String str);

    void execSQL(String str);

    b getBackPreview(Context context);

    MMFragment getHistoryFragment(Context context, Bundle bundle);

    d getMoreTabCardView(Context context, RelativeLayout relativeLayout, LinearLayout linearLayout);

    d getProfileCardView(Context context, RelativeLayout relativeLayout, LinearLayout linearLayout, int i2);

    f getStatusCardView(Context context, n nVar);

    ImageSpan getTextStatusSpanSync(String str, a.b bVar, float f2);

    void goLikeListFromSelfHistory(Context context);

    void goUnReadMsgPage(Context context);

    boolean hasStatus(String str);

    boolean isHasStatusThumb(String str);

    void report22208(long j2, String str);

    void report22210(String str, long j2);

    void setTextWithStatus(TextView textView, String str, a.b bVar, a.c cVar);

    void setTextWithStatus(NoMeasuredTextView noMeasuredTextView, String str, a.b bVar);

    void showCardDialog(Activity activity, String str);

    void showStatusDetail(Context context, String str);
}
