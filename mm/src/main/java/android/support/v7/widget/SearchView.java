package android.support.v7.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.u;
import android.support.v4.widget.f;
import android.support.v7.a.a;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public class SearchView extends LinearLayoutCompat implements android.support.v7.view.c {
    static final a awl = new a();
    private final AdapterView.OnItemSelectedListener Yj;
    private final View avA;
    final ImageView avB;
    final ImageView avC;
    final ImageView avD;
    final ImageView avE;
    final View avF;
    private e avG;
    private Rect avH;
    private Rect avI;
    private int[] avJ;
    private int[] avK;
    private final ImageView avL;
    private final Drawable avM;
    private final int avN;
    private final int avO;
    final Intent avP;
    final Intent avQ;
    private final CharSequence avR;
    private c avS;
    private b avT;
    View.OnFocusChangeListener avU;
    d avV;
    private View.OnClickListener avW;
    boolean avX;
    private boolean avY;
    f avZ;
    final SearchAutoComplete avx;
    private final View avy;
    final View avz;
    private boolean awa;
    private CharSequence awb;
    private boolean awc;
    private boolean awd;
    private boolean awe;
    private CharSequence awf;
    private CharSequence awg;
    private boolean awh;
    private int awi;
    SearchableInfo awj;
    Bundle awk;
    private final Runnable awm;
    private Runnable awn;
    private final WeakHashMap<String, Drawable.ConstantState> awo;
    View.OnKeyListener awp;
    private final TextView.OnEditorActionListener awq;
    private final AdapterView.OnItemClickListener awr;
    private TextWatcher aws;
    private int mMaxWidth;
    private final View.OnClickListener mOnClickListener;

    public interface b {
        boolean onClose();
    }

    public interface c {
        boolean mv();
    }

    public interface d {
        boolean mw();

        boolean mx();
    }

    public SearchView(Context context) {
        this(context, null);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.yj);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.avH = new Rect();
        this.avI = new Rect();
        this.avJ = new int[2];
        this.avK = new int[2];
        this.awm = new Runnable() {
            /* class android.support.v7.widget.SearchView.AnonymousClass1 */

            public final void run() {
                SearchView.this.mo();
            }
        };
        this.awn = new Runnable() {
            /* class android.support.v7.widget.SearchView.AnonymousClass3 */

            public final void run() {
                if (SearchView.this.avZ != null && (SearchView.this.avZ instanceof au)) {
                    SearchView.this.avZ.changeCursor(null);
                }
            }
        };
        this.awo = new WeakHashMap<>();
        this.mOnClickListener = new View.OnClickListener() {
            /* class android.support.v7.widget.SearchView.AnonymousClass6 */

            public final void onClick(View view) {
                String str;
                String str2;
                String str3;
                String str4 = null;
                if (view == SearchView.this.avB) {
                    SearchView.this.ms();
                } else if (view == SearchView.this.avD) {
                    SearchView.this.mr();
                } else if (view == SearchView.this.avC) {
                    SearchView.this.mq();
                } else if (view == SearchView.this.avE) {
                    SearchView searchView = SearchView.this;
                    if (searchView.awj != null) {
                        SearchableInfo searchableInfo = searchView.awj;
                        try {
                            if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                                Intent intent = new Intent(searchView.avP);
                                ComponentName searchActivity = searchableInfo.getSearchActivity();
                                if (searchActivity != null) {
                                    str4 = searchActivity.flattenToShortString();
                                }
                                intent.putExtra("calling_package", str4);
                                Context context = searchView.getContext();
                                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "android/support/v7/widget/SearchView", "onVoiceClicked", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                context.startActivity((Intent) bl.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(context, "android/support/v7/widget/SearchView", "onVoiceClicked", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                                Intent intent2 = searchView.avQ;
                                ComponentName searchActivity2 = searchableInfo.getSearchActivity();
                                Intent intent3 = new Intent("android.intent.action.SEARCH");
                                intent3.setComponent(searchActivity2);
                                PendingIntent activity = PendingIntent.getActivity(searchView.getContext(), 0, intent3, 1073741824);
                                Bundle bundle = new Bundle();
                                if (searchView.awk != null) {
                                    bundle.putParcelable("app_data", searchView.awk);
                                }
                                Intent intent4 = new Intent(intent2);
                                int i2 = 1;
                                Resources resources = searchView.getResources();
                                if (searchableInfo.getVoiceLanguageModeId() != 0) {
                                    str = resources.getString(searchableInfo.getVoiceLanguageModeId());
                                } else {
                                    str = "free_form";
                                }
                                if (searchableInfo.getVoicePromptTextId() != 0) {
                                    str2 = resources.getString(searchableInfo.getVoicePromptTextId());
                                } else {
                                    str2 = null;
                                }
                                if (searchableInfo.getVoiceLanguageId() != 0) {
                                    str3 = resources.getString(searchableInfo.getVoiceLanguageId());
                                } else {
                                    str3 = null;
                                }
                                if (searchableInfo.getVoiceMaxResults() != 0) {
                                    i2 = searchableInfo.getVoiceMaxResults();
                                }
                                intent4.putExtra("android.speech.extra.LANGUAGE_MODEL", str);
                                intent4.putExtra("android.speech.extra.PROMPT", str2);
                                intent4.putExtra("android.speech.extra.LANGUAGE", str3);
                                intent4.putExtra("android.speech.extra.MAX_RESULTS", i2);
                                if (searchActivity2 != null) {
                                    str4 = searchActivity2.flattenToShortString();
                                }
                                intent4.putExtra("calling_package", str4);
                                intent4.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
                                intent4.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
                                Context context2 = searchView.getContext();
                                com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent4);
                                com.tencent.mm.hellhoundlib.a.a.a(context2, bl2.axQ(), "android/support/v7/widget/SearchView", "onVoiceClicked", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                context2.startActivity((Intent) bl2.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(context2, "android/support/v7/widget/SearchView", "onVoiceClicked", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            }
                        } catch (ActivityNotFoundException e2) {
                        }
                    }
                } else if (view == SearchView.this.avx) {
                    SearchView.this.mu();
                }
            }
        };
        this.awp = new View.OnKeyListener() {
            /* class android.support.v7.widget.SearchView.AnonymousClass7 */

            public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                boolean z;
                if (SearchView.this.awj == null) {
                    return false;
                }
                if (SearchView.this.avx.isPopupShowing() && SearchView.this.avx.getListSelection() != -1) {
                    return SearchView.this.b(i2, keyEvent);
                }
                if (TextUtils.getTrimmedLength(SearchView.this.avx.getText()) == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i2 != 66) {
                    return false;
                }
                view.cancelLongPress();
                SearchView.this.G(SearchView.this.avx.getText().toString());
                return true;
            }
        };
        this.awq = new TextView.OnEditorActionListener() {
            /* class android.support.v7.widget.SearchView.AnonymousClass8 */

            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                SearchView.this.mq();
                return true;
            }
        };
        this.awr = new AdapterView.OnItemClickListener() {
            /* class android.support.v7.widget.SearchView.AnonymousClass9 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                SearchView.this.cw(i2);
            }
        };
        this.Yj = new AdapterView.OnItemSelectedListener() {
            /* class android.support.v7.widget.SearchView.AnonymousClass10 */

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public final void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
                SearchView searchView = SearchView.this;
                if (searchView.avV == null || !searchView.avV.mw()) {
                    Editable text = searchView.avx.getText();
                    Cursor cursor = searchView.avZ.getCursor();
                    if (cursor == null) {
                        return;
                    }
                    if (cursor.moveToPosition(i2)) {
                        CharSequence convertToString = searchView.avZ.convertToString(cursor);
                        if (convertToString != null) {
                            searchView.setQuery(convertToString);
                        } else {
                            searchView.setQuery(text);
                        }
                    } else {
                        searchView.setQuery(text);
                    }
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public final void onNothingSelected(AdapterView<?> adapterView) {
            }
        };
        this.aws = new TextWatcher() {
            /* class android.support.v7.widget.SearchView.AnonymousClass2 */

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                SearchView.this.p(charSequence);
            }

            public final void afterTextChanged(Editable editable) {
            }
        };
        az a2 = az.a(context, attributeSet, a.C0040a.SearchView, i2, 0);
        LayoutInflater.from(context).inflate(a2.getResourceId(9, R.layout.b6), (ViewGroup) this, true);
        this.avx = (SearchAutoComplete) findViewById(R.id.hf2);
        this.avx.setSearchView(this);
        this.avy = findViewById(R.id.hdw);
        this.avz = findViewById(R.id.hes);
        this.avA = findViewById(R.id.ide);
        this.avB = (ImageView) findViewById(R.id.hdd);
        this.avC = (ImageView) findViewById(R.id.he1);
        this.avD = (ImageView) findViewById(R.id.hdj);
        this.avE = (ImageView) findViewById(R.id.hf8);
        this.avL = (ImageView) findViewById(R.id.hel);
        u.a(this.avz, a2.getDrawable(10));
        u.a(this.avA, a2.getDrawable(14));
        this.avB.setImageDrawable(a2.getDrawable(13));
        this.avC.setImageDrawable(a2.getDrawable(7));
        this.avD.setImageDrawable(a2.getDrawable(4));
        this.avE.setImageDrawable(a2.getDrawable(16));
        this.avL.setImageDrawable(a2.getDrawable(13));
        this.avM = a2.getDrawable(12);
        bb.a(this.avB, getResources().getString(R.string.c5));
        this.avN = a2.getResourceId(15, R.layout.b5);
        this.avO = a2.getResourceId(5, 0);
        this.avB.setOnClickListener(this.mOnClickListener);
        this.avD.setOnClickListener(this.mOnClickListener);
        this.avC.setOnClickListener(this.mOnClickListener);
        this.avE.setOnClickListener(this.mOnClickListener);
        this.avx.setOnClickListener(this.mOnClickListener);
        this.avx.addTextChangedListener(this.aws);
        this.avx.setOnEditorActionListener(this.awq);
        this.avx.setOnItemClickListener(this.awr);
        this.avx.setOnItemSelectedListener(this.Yj);
        this.avx.setOnKeyListener(this.awp);
        this.avx.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            /* class android.support.v7.widget.SearchView.AnonymousClass4 */

            public final void onFocusChange(View view, boolean z) {
                if (SearchView.this.avU != null) {
                    SearchView.this.avU.onFocusChange(SearchView.this, z);
                }
            }
        });
        setIconifiedByDefault(a2.getBoolean(8, true));
        int dimensionPixelSize = a2.getDimensionPixelSize(1, -1);
        if (dimensionPixelSize != -1) {
            setMaxWidth(dimensionPixelSize);
        }
        this.avR = a2.getText(6);
        this.awb = a2.getText(11);
        int i3 = a2.getInt(3, -1);
        if (i3 != -1) {
            setImeOptions(i3);
        }
        int i4 = a2.getInt(2, -1);
        if (i4 != -1) {
            setInputType(i4);
        }
        setFocusable(a2.getBoolean(0, true));
        a2.ayy.recycle();
        this.avP = new Intent("android.speech.action.WEB_SEARCH");
        this.avP.addFlags(268435456);
        this.avP.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        this.avQ = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.avQ.addFlags(268435456);
        this.avF = findViewById(this.avx.getDropDownAnchor());
        if (this.avF != null) {
            this.avF.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                /* class android.support.v7.widget.SearchView.AnonymousClass5 */

                public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                    int i10;
                    int i11;
                    SearchView searchView = SearchView.this;
                    if (searchView.avF.getWidth() > 1) {
                        Resources resources = searchView.getContext().getResources();
                        int paddingLeft = searchView.avz.getPaddingLeft();
                        Rect rect = new Rect();
                        boolean d2 = bh.d(searchView);
                        if (searchView.avX) {
                            i10 = resources.getDimensionPixelSize(R.dimen.n0) + resources.getDimensionPixelSize(R.dimen.mz);
                        } else {
                            i10 = 0;
                        }
                        searchView.avx.getDropDownBackground().getPadding(rect);
                        if (d2) {
                            i11 = -rect.left;
                        } else {
                            i11 = paddingLeft - (rect.left + i10);
                        }
                        searchView.avx.setDropDownHorizontalOffset(i11);
                        searchView.avx.setDropDownWidth((i10 + ((searchView.avF.getWidth() + rect.left) + rect.right)) - paddingLeft);
                    }
                }
            });
        }
        ax(this.avX);
        mp();
    }

    /* access modifiers changed from: package-private */
    public int getSuggestionRowLayout() {
        return this.avN;
    }

    /* access modifiers changed from: package-private */
    public int getSuggestionCommitIconResId() {
        return this.avO;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setSearchableInfo(android.app.SearchableInfo r9) {
        /*
        // Method dump skipped, instructions count: 194
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.SearchView.setSearchableInfo(android.app.SearchableInfo):void");
    }

    public void setAppSearchData(Bundle bundle) {
        this.awk = bundle;
    }

    public void setImeOptions(int i2) {
        this.avx.setImeOptions(i2);
    }

    public int getImeOptions() {
        return this.avx.getImeOptions();
    }

    public void setInputType(int i2) {
        this.avx.setInputType(i2);
    }

    public int getInputType() {
        return this.avx.getInputType();
    }

    public boolean requestFocus(int i2, Rect rect) {
        if (this.awd || !isFocusable()) {
            return false;
        }
        if (this.avY) {
            return super.requestFocus(i2, rect);
        }
        boolean requestFocus = this.avx.requestFocus(i2, rect);
        if (requestFocus) {
            ax(false);
        }
        return requestFocus;
    }

    public void clearFocus() {
        this.awd = true;
        super.clearFocus();
        this.avx.clearFocus();
        this.avx.setImeVisibility(false);
        this.awd = false;
    }

    public void setOnQueryTextListener(c cVar) {
        this.avS = cVar;
    }

    public void setOnCloseListener(b bVar) {
        this.avT = bVar;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.avU = onFocusChangeListener;
    }

    public void setOnSuggestionListener(d dVar) {
        this.avV = dVar;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.avW = onClickListener;
    }

    public CharSequence getQuery() {
        return this.avx.getText();
    }

    public void setQueryHint(CharSequence charSequence) {
        this.awb = charSequence;
        mp();
    }

    public CharSequence getQueryHint() {
        if (this.awb != null) {
            return this.awb;
        }
        if (this.awj == null || this.awj.getHintId() == 0) {
            return this.avR;
        }
        return getContext().getText(this.awj.getHintId());
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.avX != z) {
            this.avX = z;
            ax(z);
            mp();
        }
    }

    public void setIconified(boolean z) {
        if (z) {
            mr();
        } else {
            ms();
        }
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.awa = z;
        ax(this.avY);
    }

    public void setQueryRefinementEnabled(boolean z) {
        int i2;
        this.awc = z;
        if (this.avZ instanceof au) {
            au auVar = (au) this.avZ;
            if (z) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            auVar.axx = i2;
        }
    }

    public void setSuggestionsAdapter(f fVar) {
        this.avZ = fVar;
        this.avx.setAdapter(this.avZ);
    }

    public f getSuggestionsAdapter() {
        return this.avZ;
    }

    public void setMaxWidth(int i2) {
        this.mMaxWidth = i2;
        requestLayout();
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.widget.LinearLayoutCompat
    public void onMeasure(int i2, int i3) {
        if (this.avY) {
            super.onMeasure(i2, i3);
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        switch (mode) {
            case Integer.MIN_VALUE:
                if (this.mMaxWidth <= 0) {
                    size = Math.min(getPreferredWidth(), size);
                    break;
                } else {
                    size = Math.min(this.mMaxWidth, size);
                    break;
                }
            case 0:
                if (this.mMaxWidth <= 0) {
                    size = getPreferredWidth();
                    break;
                } else {
                    size = this.mMaxWidth;
                    break;
                }
            case 1073741824:
                if (this.mMaxWidth > 0) {
                    size = Math.min(this.mMaxWidth, size);
                    break;
                }
                break;
        }
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        switch (mode2) {
            case Integer.MIN_VALUE:
                size2 = Math.min(getPreferredHeight(), size2);
                break;
            case 0:
                size2 = getPreferredHeight();
                break;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.widget.LinearLayoutCompat
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            SearchAutoComplete searchAutoComplete = this.avx;
            Rect rect = this.avH;
            searchAutoComplete.getLocationInWindow(this.avJ);
            getLocationInWindow(this.avK);
            int i6 = this.avJ[1] - this.avK[1];
            int i7 = this.avJ[0] - this.avK[0];
            rect.set(i7, i6, searchAutoComplete.getWidth() + i7, searchAutoComplete.getHeight() + i6);
            this.avI.set(this.avH.left, 0, this.avH.right, i5 - i3);
            if (this.avG == null) {
                this.avG = new e(this.avI, this.avH, this.avx);
                setTouchDelegate(this.avG);
                return;
            }
            this.avG.a(this.avI, this.avH);
        }
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.n_);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.n9);
    }

    private void ax(boolean z) {
        boolean z2;
        int i2;
        boolean z3 = true;
        int i3 = 8;
        this.avY = z;
        int i4 = z ? 0 : 8;
        if (!TextUtils.isEmpty(this.avx.getText())) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.avB.setVisibility(i4);
        ay(z2);
        View view = this.avy;
        if (z) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        view.setVisibility(i2);
        if (this.avL.getDrawable() != null && !this.avX) {
            i3 = 0;
        }
        this.avL.setVisibility(i3);
        mm();
        if (z2) {
            z3 = false;
        }
        az(z3);
        ml();
    }

    private boolean mk() {
        return (this.awa || this.awe) && !this.avY;
    }

    private void ay(boolean z) {
        int i2 = 8;
        if (this.awa && mk() && hasFocus() && (z || !this.awe)) {
            i2 = 0;
        }
        this.avC.setVisibility(i2);
    }

    private void ml() {
        int i2 = 8;
        if (mk() && (this.avC.getVisibility() == 0 || this.avE.getVisibility() == 0)) {
            i2 = 0;
        }
        this.avA.setVisibility(i2);
    }

    private void mm() {
        boolean z = true;
        int i2 = 0;
        boolean z2 = !TextUtils.isEmpty(this.avx.getText());
        if (!z2 && (!this.avX || this.awh)) {
            z = false;
        }
        ImageView imageView = this.avD;
        if (!z) {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        Drawable drawable = this.avD.getDrawable();
        if (drawable != null) {
            drawable.setState(z2 ? ENABLED_STATE_SET : EMPTY_STATE_SET);
        }
    }

    private void mn() {
        post(this.awm);
    }

    /* access modifiers changed from: package-private */
    public final void mo() {
        int[] iArr = this.avx.hasFocus() ? FOCUSED_STATE_SET : EMPTY_STATE_SET;
        Drawable background = this.avz.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.avA.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        removeCallbacks(this.awm);
        post(this.awn);
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: package-private */
    public final boolean b(int i2, KeyEvent keyEvent) {
        int length;
        if (this.awj == null || this.avZ == null || keyEvent.getAction() != 0 || !keyEvent.hasNoModifiers()) {
            return false;
        }
        if (i2 == 66 || i2 == 84 || i2 == 61) {
            return cw(this.avx.getListSelection());
        }
        if (i2 == 21 || i2 == 22) {
            if (i2 == 21) {
                length = 0;
            } else {
                length = this.avx.length();
            }
            this.avx.setSelection(length);
            this.avx.setListSelection(0);
            this.avx.clearListSelection();
            awl.c(this.avx);
            return true;
        }
        if (!(i2 == 19 && this.avx.getListSelection() == 0)) {
        }
        return false;
    }

    private CharSequence o(CharSequence charSequence) {
        if (!this.avX || this.avM == null) {
            return charSequence;
        }
        int textSize = (int) (((double) this.avx.getTextSize()) * 1.25d);
        this.avM.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.avM), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    private void mp() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.avx;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(o(queryHint));
    }

    private void az(boolean z) {
        int i2;
        if (!this.awe || this.avY || !z) {
            i2 = 8;
        } else {
            i2 = 0;
            this.avC.setVisibility(8);
        }
        this.avE.setVisibility(i2);
    }

    /* access modifiers changed from: package-private */
    public final void p(CharSequence charSequence) {
        boolean z = true;
        Editable text = this.avx.getText();
        this.awg = text;
        boolean z2 = !TextUtils.isEmpty(text);
        ay(z2);
        if (z2) {
            z = false;
        }
        az(z);
        mm();
        ml();
        if (this.avS != null && !TextUtils.equals(charSequence, this.awf)) {
            charSequence.toString();
        }
        this.awf = charSequence.toString();
    }

    /* access modifiers changed from: package-private */
    public final void mq() {
        Editable text = this.avx.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            if (this.avS != null) {
                c cVar = this.avS;
                text.toString();
                if (cVar.mv()) {
                    return;
                }
            }
            if (this.awj != null) {
                G(text.toString());
            }
            this.avx.setImeVisibility(false);
            this.avx.dismissDropDown();
        }
    }

    /* access modifiers changed from: package-private */
    public final void mr() {
        if (!TextUtils.isEmpty(this.avx.getText())) {
            this.avx.setText("");
            this.avx.requestFocus();
            this.avx.setImeVisibility(true);
        } else if (!this.avX) {
        } else {
            if (this.avT == null || !this.avT.onClose()) {
                clearFocus();
                ax(true);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void ms() {
        ax(false);
        this.avx.requestFocus();
        this.avx.setImeVisibility(true);
        if (this.avW != null) {
            this.avW.onClick(this);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        mn();
    }

    @Override // android.support.v7.view.c
    public final void onActionViewCollapsed() {
        this.avx.setText("");
        this.avx.setSelection(this.avx.length());
        this.awg = "";
        clearFocus();
        ax(true);
        this.avx.setImeOptions(this.awi);
        this.awh = false;
    }

    @Override // android.support.v7.view.c
    public final void onActionViewExpanded() {
        if (!this.awh) {
            this.awh = true;
            this.awi = this.avx.getImeOptions();
            this.avx.setImeOptions(this.awi | TPMediaCodecProfileLevel.HEVCHighTierLevel62);
            this.avx.setText("");
            setIconified(false);
        }
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* class android.support.v7.widget.SearchView.SavedState.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public final /* synthetic */ SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new SavedState[i2];
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        };
        boolean awx;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.awx = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        @Override // android.support.v4.view.AbsSavedState
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeValue(Boolean.valueOf(this.awx));
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.awx + "}";
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.awx = this.avY;
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.Pm);
        ax(savedState.awx);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public final boolean cw(int i2) {
        if (this.avV != null && this.avV.mx()) {
            return false;
        }
        cx(i2);
        this.avx.setImeVisibility(false);
        this.avx.dismissDropDown();
        return true;
    }

    private boolean cx(int i2) {
        Cursor cursor = this.avZ.getCursor();
        if (cursor == null || !cursor.moveToPosition(i2)) {
            return false;
        }
        c(a(cursor));
        return true;
    }

    private void c(Intent intent) {
        if (intent != null) {
            try {
                Context context = getContext();
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "android/support/v7/widget/SearchView", "launchIntent", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "android/support/v7/widget/SearchView", "launchIntent", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            } catch (RuntimeException e2) {
                new StringBuilder("Failed launch activity: ").append(intent);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setQuery(CharSequence charSequence) {
        this.avx.setText(charSequence);
        this.avx.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    /* access modifiers changed from: package-private */
    public final void G(String str) {
        Intent a2 = a("android.intent.action.SEARCH", null, null, str, 0, null);
        Context context = getContext();
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(a2);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "android/support/v7/widget/SearchView", "launchQuerySearch", "(ILjava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "android/support/v7/widget/SearchView", "launchQuerySearch", "(ILjava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }

    private Intent a(String str, Uri uri, String str2, String str3, int i2, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.awg);
        if (str3 != null) {
            intent.putExtra(SearchIntents.EXTRA_QUERY, str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        if (this.awk != null) {
            intent.putExtra("app_data", this.awk);
        }
        intent.setComponent(this.awj.getSearchActivity());
        return intent;
    }

    private Intent a(Cursor cursor) {
        int i2;
        String a2;
        try {
            String a3 = au.a(cursor, "suggest_intent_action");
            if (a3 == null) {
                a3 = this.awj.getSuggestIntentAction();
            }
            if (a3 == null) {
                a3 = "android.intent.action.SEARCH";
            }
            String a4 = au.a(cursor, "suggest_intent_data");
            if (a4 == null) {
                a4 = this.awj.getSuggestIntentData();
            }
            if (!(a4 == null || (a2 = au.a(cursor, "suggest_intent_data_id")) == null)) {
                a4 = a4 + FilePathGenerator.ANDROID_DIR_SEP + Uri.encode(a2);
            }
            return a(a3, a4 == null ? null : Uri.parse(a4), au.a(cursor, "suggest_intent_extra_data"), au.a(cursor, "suggest_intent_query"), 0, null);
        } catch (RuntimeException e2) {
            try {
                i2 = cursor.getPosition();
            } catch (RuntimeException e3) {
                i2 = -1;
            }
            new StringBuilder("Search suggestions cursor at row ").append(i2).append(" returned exception.");
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void mu() {
        awl.a(this.avx);
        awl.b(this.avx);
    }

    static boolean ad(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    static class e extends TouchDelegate {
        private final View awC;
        private final Rect awD = new Rect();
        private final Rect awE = new Rect();
        private final Rect awF = new Rect();
        private final int awG;
        private boolean awH;

        public e(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.awG = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            a(rect, rect2);
            this.awC = view;
        }

        public final void a(Rect rect, Rect rect2) {
            this.awD.set(rect);
            this.awF.set(rect);
            this.awF.inset(-this.awG, -this.awG);
            this.awE.set(rect2);
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        public final boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z;
            boolean z2;
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            switch (motionEvent.getAction()) {
                case 0:
                    if (this.awD.contains(x, y)) {
                        this.awH = true;
                        z2 = true;
                        z = true;
                        break;
                    }
                    z2 = true;
                    z = false;
                    break;
                case 1:
                case 2:
                    z = this.awH;
                    if (z && !this.awF.contains(x, y)) {
                        z2 = false;
                        break;
                    }
                    z2 = true;
                    break;
                case 3:
                    z = this.awH;
                    this.awH = false;
                    z2 = true;
                    break;
                default:
                    z2 = true;
                    z = false;
                    break;
            }
            if (!z) {
                return false;
            }
            if (!z2 || this.awE.contains(x, y)) {
                motionEvent.setLocation((float) (x - this.awE.left), (float) (y - this.awE.top));
            } else {
                motionEvent.setLocation((float) (this.awC.getWidth() / 2), (float) (this.awC.getHeight() / 2));
            }
            return this.awC.dispatchTouchEvent(motionEvent);
        }
    }

    public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {
        final Runnable awA;
        private SearchView awy;
        boolean awz;
        private int mThreshold;

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, R.attr.bp);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
            this.awA = new Runnable() {
                /* class android.support.v7.widget.SearchView.SearchAutoComplete.AnonymousClass1 */

                public final void run() {
                    SearchAutoComplete searchAutoComplete = SearchAutoComplete.this;
                    if (searchAutoComplete.awz) {
                        ((InputMethodManager) searchAutoComplete.getContext().getSystemService("input_method")).showSoftInput(searchAutoComplete, 0);
                        searchAutoComplete.awz = false;
                    }
                }
            };
            this.mThreshold = getThreshold();
        }

        /* access modifiers changed from: protected */
        public void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, (float) getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        /* access modifiers changed from: package-private */
        public void setSearchView(SearchView searchView) {
            this.awy = searchView;
        }

        public void setThreshold(int i2) {
            super.setThreshold(i2);
            this.mThreshold = i2;
        }

        /* access modifiers changed from: protected */
        public void replaceText(CharSequence charSequence) {
        }

        public void performCompletion() {
        }

        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.awy.hasFocus() && getVisibility() == 0) {
                this.awz = true;
                if (SearchView.ad(getContext())) {
                    SearchView.awl.c(this);
                }
            }
        }

        /* access modifiers changed from: protected */
        public void onFocusChanged(boolean z, int i2, Rect rect) {
            super.onFocusChanged(z, i2, rect);
            this.awy.mt();
        }

        public boolean enoughToFilter() {
            return this.mThreshold <= 0 || super.enoughToFilter();
        }

        public boolean onKeyPreIme(int i2, KeyEvent keyEvent) {
            if (i2 == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState == null) {
                        return true;
                    }
                    keyDispatcherState.startTracking(keyEvent, this);
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.awy.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i2, keyEvent);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i2 = configuration.screenWidthDp;
            int i3 = configuration.screenHeightDp;
            if (i2 >= 960 && i3 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i2 >= 600 || (i2 >= 640 && i3 >= 480)) {
                return 192;
            }
            return 160;
        }

        @Override // android.support.v7.widget.AppCompatAutoCompleteTextView
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.awz) {
                removeCallbacks(this.awA);
                post(this.awA);
            }
            return onCreateInputConnection;
        }

        /* access modifiers changed from: package-private */
        public void setImeVisibility(boolean z) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z) {
                this.awz = false;
                removeCallbacks(this.awA);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else if (inputMethodManager.isActive(this)) {
                this.awz = false;
                removeCallbacks(this.awA);
                inputMethodManager.showSoftInput(this, 0);
            } else {
                this.awz = true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class a {
        private Method awu;
        private Method awv;
        private Method aww;

        a() {
            try {
                this.awu = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.awu.setAccessible(true);
            } catch (NoSuchMethodException e2) {
            }
            try {
                this.awv = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.awv.setAccessible(true);
            } catch (NoSuchMethodException e3) {
            }
            try {
                this.aww = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                this.aww.setAccessible(true);
            } catch (NoSuchMethodException e4) {
            }
        }

        /* access modifiers changed from: package-private */
        public final void a(AutoCompleteTextView autoCompleteTextView) {
            if (this.awu != null) {
                try {
                    this.awu.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception e2) {
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void b(AutoCompleteTextView autoCompleteTextView) {
            if (this.awv != null) {
                try {
                    this.awv.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception e2) {
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void c(AutoCompleteTextView autoCompleteTextView) {
            if (this.aww != null) {
                try {
                    this.aww.invoke(autoCompleteTextView, Boolean.TRUE);
                } catch (Exception e2) {
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void mt() {
        ax(this.avY);
        mn();
        if (this.avx.hasFocus()) {
            mu();
        }
    }
}
