package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ae.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aa;
import java.util.List;

public class Preference implements Comparable<Preference> {
    private CharSequence Bic;
    private ImageView EbJ;
    private CharSequence Hn;
    int Kxl;
    private boolean OZA;
    public boolean OZB;
    public boolean OZC;
    private boolean OZD;
    private boolean OZE;
    private int OZF;
    public int OZG;
    private boolean OZH;
    private List<Preference> OZI;
    private a OZo;
    public b OZp;
    public c OZq;
    private int OZr;
    private int OZs;
    private String OZt;
    boolean OZu;
    private boolean OZv;
    public boolean OZw;
    String OZx;
    private boolean OZy;
    private int OZz;
    private int[] QA;
    protected Drawable Xw;
    protected int aeN;
    private int bJH;
    public final Context mContext;
    private Object mDefaultValue;
    private boolean mEnabled;
    private Bundle mExtras;
    public String mKey;
    public int qlp;

    public interface a {
        boolean a(Preference preference, Object obj);
    }

    public interface b {
        boolean a(Preference preference);
    }

    public interface c {
        boolean eFh();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Preference preference) {
        AppMethodBeat.i(142654);
        Preference preference2 = preference;
        if (this.bJH != Integer.MAX_VALUE || (this.bJH == Integer.MAX_VALUE && preference2.bJH != Integer.MAX_VALUE)) {
            int i2 = this.bJH - preference2.bJH;
            AppMethodBeat.o(142654);
            return i2;
        } else if (this.Hn == null) {
            AppMethodBeat.o(142654);
            return 1;
        } else if (preference2.Hn == null) {
            AppMethodBeat.o(142654);
            return -1;
        } else {
            CharSequence charSequence = this.Hn;
            CharSequence charSequence2 = preference2.Hn;
            int length = charSequence.length();
            int length2 = charSequence2.length();
            int i3 = length < length2 ? length : length2;
            int i4 = 0;
            int i5 = 0;
            while (i5 < i3) {
                int i6 = i5 + 1;
                int i7 = i4 + 1;
                int lowerCase = Character.toLowerCase(charSequence.charAt(i5)) - Character.toLowerCase(charSequence2.charAt(i4));
                if (lowerCase != 0) {
                    AppMethodBeat.o(142654);
                    return lowerCase;
                }
                i4 = i7;
                i5 = i6;
            }
            int i8 = length - length2;
            AppMethodBeat.o(142654);
            return i8;
        }
    }

    public Preference(Context context, AttributeSet attributeSet, int i2) {
        AppMethodBeat.i(142632);
        this.QA = new int[]{R.attr.a31, R.attr.a0f};
        this.bJH = Integer.MAX_VALUE;
        this.Kxl = 0;
        this.mEnabled = true;
        this.OZu = true;
        this.OZw = true;
        this.OZy = true;
        this.qlp = -1;
        this.EbJ = null;
        this.OZz = 0;
        this.OZA = false;
        this.OZB = false;
        this.OZC = false;
        this.OZD = false;
        this.OZE = true;
        this.OZF = R.layout.b8j;
        this.OZH = false;
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0244a.Preference, i2, 0);
        for (int indexCount = obtainStyledAttributes.getIndexCount(); indexCount >= 0; indexCount--) {
            int index = obtainStyledAttributes.getIndex(indexCount);
            if (index == 4) {
                this.aeN = obtainStyledAttributes.getResourceId(index, 0);
            } else if (index == 5) {
                this.Kxl = obtainStyledAttributes.getColor(index, 0);
            } else if (index == 6) {
                this.mKey = obtainStyledAttributes.getString(index);
            } else if (index == 13) {
                this.OZr = obtainStyledAttributes.getResourceId(index, 0);
                this.Hn = obtainStyledAttributes.getString(index);
                if (this.OZr != 0) {
                    this.Hn = context.getString(this.OZr);
                }
            } else if (index == 12) {
                this.Bic = obtainStyledAttributes.getString(index);
                this.OZs = obtainStyledAttributes.getResourceId(index, 0);
                if (this.OZs != 0) {
                    this.Bic = context.getString(this.OZs);
                }
            } else if (index == 8) {
                this.bJH = obtainStyledAttributes.getInt(index, this.bJH);
            } else if (index == 3) {
                this.OZt = obtainStyledAttributes.getString(index);
            } else if (index == 7) {
                this.OZF = obtainStyledAttributes.getResourceId(index, this.OZF);
            } else if (index == 14) {
                this.OZG = obtainStyledAttributes.getResourceId(index, this.OZG);
            } else if (index == 2) {
                this.mEnabled = obtainStyledAttributes.getBoolean(index, true);
            } else if (index == 10) {
                this.OZu = obtainStyledAttributes.getBoolean(index, true);
            } else if (index == 9) {
                this.OZw = obtainStyledAttributes.getBoolean(index, this.OZw);
            } else if (index == 1) {
                this.OZx = obtainStyledAttributes.getString(index);
            } else if (index == 0) {
                this.mDefaultValue = null;
            } else if (index == 11) {
                this.OZE = obtainStyledAttributes.getBoolean(index, this.OZE);
            }
        }
        obtainStyledAttributes.recycle();
        if (!getClass().getName().startsWith("android.preference")) {
            this.OZH = true;
        }
        AppMethodBeat.o(142632);
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842894);
    }

    public Preference(Context context) {
        this(context, null);
    }

    public final Bundle getExtras() {
        AppMethodBeat.i(142633);
        if (this.mExtras == null) {
            this.mExtras = new Bundle();
        }
        Bundle bundle = this.mExtras;
        AppMethodBeat.o(142633);
        return bundle;
    }

    public final void setLayoutResource(int i2) {
        if (i2 != this.OZF) {
            this.OZH = true;
        }
        this.OZF = i2;
    }

    public int getLayoutResource() {
        return this.OZF;
    }

    public final void setWidgetLayoutResource(int i2) {
        if (i2 != this.OZG) {
            this.OZH = true;
        }
        this.OZG = i2;
    }

    public View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.i(142634);
        if (view == null) {
            view = onCreateView(viewGroup);
        }
        onBindView(view);
        AppMethodBeat.o(142634);
        return view;
    }

    /* access modifiers changed from: protected */
    public View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(142635);
        LayoutInflater jQ = aa.jQ(this.mContext);
        View inflate = jQ.inflate(this.OZF, viewGroup, false);
        ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(16908312);
        if (viewGroup2 != null) {
            if (this.OZG != 0) {
                jQ.inflate(this.OZG, viewGroup2);
            } else {
                viewGroup2.setVisibility(8);
            }
        }
        AppMethodBeat.o(142635);
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onBindView(View view) {
        AppMethodBeat.i(142636);
        View findViewById = view.findViewById(R.id.be9);
        if (findViewById != null) {
            findViewById.setMinimumHeight((int) (((float) this.mContext.getResources().getDimensionPixelSize(R.dimen.i0)) * com.tencent.mm.cb.a.jj(this.mContext)));
            Log.d("dancy test", "resource:%s, height:%s, scale:%s", this.mContext.getResources(), Integer.valueOf(this.mContext.getResources().getDimensionPixelSize(R.dimen.i0)), Float.valueOf(com.tencent.mm.cb.a.jj(this.mContext)));
        }
        final TextView textView = (TextView) view.findViewById(16908310);
        if (textView != null) {
            CharSequence title = getTitle();
            if (title == null || !(title instanceof Spannable)) {
                textView.setMovementMethod(null);
            } else {
                if (this.OZC) {
                    textView.setClickable(true);
                }
                if (textView.isClickable()) {
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                }
            }
            textView.setText(title);
        }
        final TextView textView2 = (TextView) view.findViewById(16908304);
        if (textView2 != null) {
            if (!TextUtils.isEmpty(getSummary())) {
                if (textView2.getVisibility() != 0) {
                    textView2.setVisibility(0);
                }
                if (this.OZB) {
                    textView2.setMovementMethod(LinkMovementMethod.getInstance());
                    textView2.setClickable(true);
                    textView2.setText(getSummary(), TextView.BufferType.SPANNABLE);
                } else {
                    textView2.setText(getSummary());
                }
                if (this.qlp != -1) {
                    textView2.setTextColor(this.qlp);
                }
                if (this.OZD) {
                    textView2.setSingleLine();
                }
                if (textView != null && this.OZA) {
                    textView2.post(new Runnable() {
                        /* class com.tencent.mm.ui.base.preference.Preference.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(164171);
                            CharSequence summary = Preference.this.getSummary();
                            if (summary == null) {
                                AppMethodBeat.o(164171);
                                return;
                            }
                            int measuredWidth = textView2.getMeasuredWidth() + textView.getMeasuredWidth();
                            if (measuredWidth > 0) {
                                int measureText = (int) textView.getPaint().measureText(textView.getText().toString());
                                if (((int) textView2.getPaint().measureText(summary, 0, summary.length())) + measureText > measuredWidth) {
                                    textView2.setText(TextUtils.ellipsize(summary, textView2.getPaint(), (float) ((measuredWidth - measureText) - 5), TextUtils.TruncateAt.END));
                                }
                            }
                            AppMethodBeat.o(164171);
                        }
                    });
                }
            } else if (textView2.getVisibility() != 8) {
                textView2.setVisibility(8);
            }
        }
        ImageView imageView = (ImageView) view.findViewById(16908294);
        if (imageView != null) {
            if (!(this.aeN == 0 && this.Xw == null)) {
                if (this.Xw == null) {
                    this.Xw = this.mContext.getResources().getDrawable(this.aeN);
                }
                if (this.Xw != null) {
                    imageView.setImageDrawable(this.Xw);
                    if (this.Kxl != 0) {
                        imageView.getDrawable().setColorFilter(this.Kxl, PorterDuff.Mode.SRC_ATOP);
                    }
                }
            }
            imageView.setVisibility(this.Xw != null ? 0 : 8);
        }
        this.EbJ = (ImageView) view.findViewById(R.id.h6o);
        if (this.EbJ != null) {
            this.EbJ.setVisibility(this.OZz);
        }
        if (this.OZE) {
            z(view, isEnabled());
        }
        AppMethodBeat.o(142636);
    }

    private void z(View view, boolean z) {
        AppMethodBeat.i(142637);
        view.setEnabled(z);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                z(viewGroup.getChildAt(childCount), z);
            }
        }
        AppMethodBeat.o(142637);
    }

    public void setTitle(CharSequence charSequence) {
        AppMethodBeat.i(142638);
        if ((charSequence == null && this.Hn != null) || (charSequence != null && !charSequence.equals(this.Hn))) {
            this.OZr = 0;
            this.Hn = charSequence;
            notifyChanged();
        }
        AppMethodBeat.o(142638);
    }

    public void setTitle(int i2) {
        AppMethodBeat.i(142639);
        setTitle(this.mContext.getString(i2));
        this.OZr = i2;
        AppMethodBeat.o(142639);
    }

    public CharSequence getTitle() {
        return this.Hn;
    }

    public void gr() {
        AppMethodBeat.i(142640);
        this.aeN = R.raw.addfriend_icon_invite;
        Drawable drawable = this.mContext.getResources().getDrawable(R.raw.addfriend_icon_invite);
        if ((drawable == null && this.Xw != null) || !(drawable == null || this.Xw == drawable)) {
            this.Xw = drawable;
            notifyChanged();
        }
        AppMethodBeat.o(142640);
    }

    public CharSequence getSummary() {
        return this.Bic;
    }

    public void setSummary(CharSequence charSequence) {
        AppMethodBeat.i(142641);
        if ((charSequence == null && this.Bic != null) || (charSequence != null && !charSequence.equals(this.Bic))) {
            this.Bic = charSequence;
            notifyChanged();
        }
        AppMethodBeat.o(142641);
    }

    public void setSummary(int i2) {
        AppMethodBeat.i(142642);
        setSummary(this.mContext.getString(i2));
        AppMethodBeat.o(142642);
    }

    public final void setEnabled(boolean z) {
        AppMethodBeat.i(142643);
        if (this.mEnabled != z) {
            this.mEnabled = z;
            notifyDependencyChange(shouldDisableDependents());
            notifyChanged();
        }
        AppMethodBeat.o(142643);
    }

    public final boolean isEnabled() {
        return this.mEnabled && this.OZy;
    }

    public final void setSelectable(boolean z) {
        AppMethodBeat.i(142644);
        if (this.OZu != z) {
            this.OZu = z;
            notifyChanged();
        }
        AppMethodBeat.o(142644);
    }

    public final void setKey(String str) {
        AppMethodBeat.i(142645);
        this.mKey = str;
        if (this.OZv && !hasKey()) {
            gLQ();
        }
        AppMethodBeat.o(142645);
    }

    public final String getKey() {
        return this.mKey;
    }

    private void gLQ() {
        AppMethodBeat.i(142646);
        if (this.mKey == null) {
            IllegalStateException illegalStateException = new IllegalStateException("Preference does not have a key assigned.");
            AppMethodBeat.o(142646);
            throw illegalStateException;
        }
        this.OZv = true;
        AppMethodBeat.o(142646);
    }

    private boolean hasKey() {
        AppMethodBeat.i(142647);
        if (!TextUtils.isEmpty(this.mKey)) {
            AppMethodBeat.o(142647);
            return true;
        }
        AppMethodBeat.o(142647);
        return false;
    }

    public final void gLR() {
        this.OZw = false;
    }

    public final boolean callChangeListener(Object obj) {
        AppMethodBeat.i(142648);
        if (this.OZo == null) {
            AppMethodBeat.o(142648);
            return true;
        }
        boolean a2 = this.OZo.a(this, obj);
        AppMethodBeat.o(142648);
        return a2;
    }

    public void a(a aVar) {
        this.OZo = aVar;
    }

    public final Context getContext() {
        return this.mContext;
    }

    /* access modifiers changed from: protected */
    public void notifyChanged() {
    }

    private void notifyDependencyChange(boolean z) {
        AppMethodBeat.i(142649);
        List<Preference> list = this.OZI;
        if (list == null) {
            AppMethodBeat.o(142649);
            return;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            list.get(i2).BD(z);
        }
        AppMethodBeat.o(142649);
    }

    private void BD(boolean z) {
        AppMethodBeat.i(142650);
        if (this.OZy == z) {
            this.OZy = !z;
            notifyDependencyChange(shouldDisableDependents());
            notifyChanged();
        }
        AppMethodBeat.o(142650);
    }

    private boolean shouldDisableDependents() {
        AppMethodBeat.i(142651);
        if (!isEnabled()) {
            AppMethodBeat.o(142651);
            return true;
        }
        AppMethodBeat.o(142651);
        return false;
    }

    public final void alO(int i2) {
        AppMethodBeat.i(142652);
        this.OZz = i2;
        if (this.EbJ != null) {
            this.EbJ.setVisibility(i2);
        }
        AppMethodBeat.o(142652);
    }

    public final void gLS() {
        this.OZD = true;
    }

    public static class BaseSavedState extends AbsSavedState {
        public static final Parcelable.Creator<BaseSavedState> CREATOR = new Parcelable.Creator<BaseSavedState>() {
            /* class com.tencent.mm.ui.base.preference.Preference.BaseSavedState.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ BaseSavedState[] newArray(int i2) {
                return new BaseSavedState[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ BaseSavedState createFromParcel(Parcel parcel) {
                AppMethodBeat.i(142630);
                BaseSavedState baseSavedState = new BaseSavedState(parcel);
                AppMethodBeat.o(142630);
                return baseSavedState;
            }
        };

        public BaseSavedState(Parcel parcel) {
            super(parcel);
        }

        static {
            AppMethodBeat.i(142631);
            AppMethodBeat.o(142631);
        }
    }

    public String toString() {
        AppMethodBeat.i(142653);
        StringBuilder sb = new StringBuilder();
        CharSequence title = getTitle();
        if (!TextUtils.isEmpty(title)) {
            sb.append(title).append(' ');
        }
        CharSequence summary = getSummary();
        if (!TextUtils.isEmpty(summary)) {
            sb.append(summary).append(' ');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(142653);
        return sb2;
    }
}
