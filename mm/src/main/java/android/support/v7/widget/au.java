package android.support.v7.widget;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.b;
import android.support.v4.widget.o;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

final class au extends o implements View.OnClickListener {
    private final SearchableInfo awj;
    private final WeakHashMap<String, Drawable.ConstantState> awo;
    private final SearchView awy;
    private int axA = -1;
    private int axB = -1;
    private int axC = -1;
    private int axD = -1;
    private int axE = -1;
    private final SearchManager axu = ((SearchManager) this.mContext.getSystemService("search"));
    private final Context axv;
    private final int axw;
    int axx = 1;
    private ColorStateList axy;
    private int axz = -1;
    private boolean mClosed = false;

    public au(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout());
        this.awy = searchView;
        this.awj = searchableInfo;
        this.axw = searchView.getSuggestionCommitIconResId();
        this.axv = context;
        this.awo = weakHashMap;
    }

    @Override // android.support.v4.widget.f
    public final boolean hasStableIds() {
        return false;
    }

    @Override // android.support.v4.widget.f, android.support.v4.widget.g.a
    public final Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        String[] strArr;
        Cursor query;
        String charSequence2 = charSequence == null ? "" : charSequence.toString();
        if (this.awy.getVisibility() != 0 || this.awy.getWindowVisibility() != 0) {
            return null;
        }
        try {
            SearchableInfo searchableInfo = this.awj;
            if (searchableInfo == null) {
                query = null;
            } else {
                String suggestAuthority = searchableInfo.getSuggestAuthority();
                if (suggestAuthority == null) {
                    query = null;
                } else {
                    Uri.Builder fragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
                    String suggestPath = searchableInfo.getSuggestPath();
                    if (suggestPath != null) {
                        fragment.appendEncodedPath(suggestPath);
                    }
                    fragment.appendPath("search_suggest_query");
                    String suggestSelection = searchableInfo.getSuggestSelection();
                    if (suggestSelection != null) {
                        strArr = new String[]{charSequence2};
                    } else {
                        fragment.appendPath(charSequence2);
                        strArr = null;
                    }
                    fragment.appendQueryParameter("limit", "50");
                    query = this.mContext.getContentResolver().query(fragment.build(), null, suggestSelection, strArr, null);
                }
            }
            if (query != null) {
                query.getCount();
                return query;
            }
        } catch (RuntimeException e2) {
        }
        return null;
    }

    public final void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        b(getCursor());
    }

    public final void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        b(getCursor());
    }

    private static void b(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras == null || extras.getBoolean("in_progress")) {
        }
    }

    @Override // android.support.v4.widget.f, android.support.v4.widget.g.a
    public final void changeCursor(Cursor cursor) {
        if (!this.mClosed) {
            try {
                super.changeCursor(cursor);
                if (cursor != null) {
                    this.axz = cursor.getColumnIndex("suggest_text_1");
                    this.axA = cursor.getColumnIndex("suggest_text_2");
                    this.axB = cursor.getColumnIndex("suggest_text_2_url");
                    this.axC = cursor.getColumnIndex("suggest_icon_1");
                    this.axD = cursor.getColumnIndex("suggest_icon_2");
                    this.axE = cursor.getColumnIndex("suggest_flags");
                }
            } catch (Exception e2) {
            }
        } else if (cursor != null) {
            cursor.close();
        }
    }

    @Override // android.support.v4.widget.f, android.support.v4.widget.o
    public final View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View newView = super.newView(context, cursor, viewGroup);
        newView.setTag(new a(newView));
        ((ImageView) newView.findViewById(R.id.bw1)).setImageResource(this.axw);
        return newView;
    }

    /* access modifiers changed from: package-private */
    public static final class a {
        public final TextView axF;
        public final TextView axG;
        public final ImageView axH;
        public final ImageView axI;
        public final ImageView axJ;

        public a(View view) {
            this.axF = (TextView) view.findViewById(16908308);
            this.axG = (TextView) view.findViewById(16908309);
            this.axH = (ImageView) view.findViewById(16908295);
            this.axI = (ImageView) view.findViewById(16908296);
            this.axJ = (ImageView) view.findViewById(R.id.bw1);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v1, resolved type: android.text.SpannableString */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.support.v4.widget.f
    public final void a(View view, Cursor cursor) {
        int i2;
        Drawable H;
        String a2;
        Drawable drawable = null;
        a aVar = (a) view.getTag();
        if (this.axE != -1) {
            i2 = cursor.getInt(this.axE);
        } else {
            i2 = 0;
        }
        if (aVar.axF != null) {
            b(aVar.axF, a(cursor, this.axz));
        }
        if (aVar.axG != null) {
            String a3 = a(cursor, this.axB);
            if (a3 != null) {
                if (this.axy == null) {
                    TypedValue typedValue = new TypedValue();
                    this.mContext.getTheme().resolveAttribute(R.attr.a29, typedValue, true);
                    this.axy = this.mContext.getResources().getColorStateList(typedValue.resourceId);
                }
                SpannableString spannableString = new SpannableString(a3);
                spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.axy, null), 0, a3.length(), 33);
                a2 = spannableString;
            } else {
                a2 = a(cursor, this.axA);
            }
            if (TextUtils.isEmpty(a2)) {
                if (aVar.axF != null) {
                    aVar.axF.setSingleLine(false);
                    aVar.axF.setMaxLines(2);
                }
            } else if (aVar.axF != null) {
                aVar.axF.setSingleLine(true);
                aVar.axF.setMaxLines(1);
            }
            b(aVar.axG, a2);
        }
        if (aVar.axH != null) {
            ImageView imageView = aVar.axH;
            if (this.axC == -1) {
                H = null;
            } else {
                H = H(cursor.getString(this.axC));
                if (H == null) {
                    ComponentName searchActivity = this.awj.getSearchActivity();
                    String flattenToShortString = searchActivity.flattenToShortString();
                    if (this.awo.containsKey(flattenToShortString)) {
                        Drawable.ConstantState constantState = this.awo.get(flattenToShortString);
                        if (constantState == null) {
                            H = null;
                        } else {
                            H = constantState.newDrawable(this.axv.getResources());
                        }
                    } else {
                        Drawable activityIcon = getActivityIcon(searchActivity);
                        this.awo.put(flattenToShortString, activityIcon == null ? null : activityIcon.getConstantState());
                        H = activityIcon;
                    }
                    if (H == null) {
                        H = this.mContext.getPackageManager().getDefaultActivityIcon();
                    }
                }
            }
            a(imageView, H, 4);
        }
        if (aVar.axI != null) {
            ImageView imageView2 = aVar.axI;
            if (this.axD != -1) {
                drawable = H(cursor.getString(this.axD));
            }
            a(imageView2, drawable, 8);
        }
        if (this.axx == 2 || (this.axx == 1 && (i2 & 1) != 0)) {
            aVar.axJ.setVisibility(0);
            aVar.axJ.setTag(aVar.axF.getText());
            aVar.axJ.setOnClickListener(this);
            return;
        }
        aVar.axJ.setVisibility(8);
    }

    public final void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.awy.setQuery((CharSequence) tag);
        }
    }

    private static void b(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    private static void a(ImageView imageView, Drawable drawable, int i2) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i2);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    @Override // android.support.v4.widget.f, android.support.v4.widget.g.a
    public final CharSequence convertToString(Cursor cursor) {
        String a2;
        String a3;
        if (cursor == null) {
            return null;
        }
        String a4 = a(cursor, "suggest_intent_query");
        if (a4 != null) {
            return a4;
        }
        if (this.awj.shouldRewriteQueryFromData() && (a3 = a(cursor, "suggest_intent_data")) != null) {
            return a3;
        }
        if (!this.awj.shouldRewriteQueryFromText() || (a2 = a(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return a2;
    }

    @Override // android.support.v4.widget.f
    public final View getView(int i2, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i2, view, viewGroup);
        } catch (RuntimeException e2) {
            View newView = newView(this.mContext, this.To, viewGroup);
            if (newView != null) {
                ((a) newView.getTag()).axF.setText(e2.toString());
            }
            return newView;
        }
    }

    @Override // android.support.v4.widget.f
    public final View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i2, view, viewGroup);
        } catch (RuntimeException e2) {
            View newDropDownView = newDropDownView(this.mContext, this.To, viewGroup);
            if (newDropDownView != null) {
                ((a) newDropDownView.getTag()).axF.setText(e2.toString());
            }
            return newDropDownView;
        }
    }

    private Drawable H(String str) {
        if (str == null || str.isEmpty() || AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str)) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.axv.getPackageName() + FilePathGenerator.ANDROID_DIR_SEP + parseInt;
            Drawable I = I(str2);
            if (I != null) {
                return I;
            }
            Drawable l = b.l(this.axv, parseInt);
            a(str2, l);
            return l;
        } catch (NumberFormatException e2) {
            Drawable I2 = I(str);
            if (I2 != null) {
                return I2;
            }
            Drawable d2 = d(Uri.parse(str));
            a(str, d2);
            return d2;
        } catch (Resources.NotFoundException e3) {
            return null;
        }
    }

    private Drawable d(Uri uri) {
        try {
            if ("android.resource".equals(uri.getScheme())) {
                try {
                    return e(uri);
                } catch (Resources.NotFoundException e2) {
                    throw new FileNotFoundException("Resource does not exist: ".concat(String.valueOf(uri)));
                }
            } else {
                InputStream openInputStream = this.axv.getContentResolver().openInputStream(uri);
                if (openInputStream == null) {
                    throw new FileNotFoundException("Failed to open ".concat(String.valueOf(uri)));
                }
                try {
                    Drawable createFromStream = Drawable.createFromStream(openInputStream, null);
                    try {
                        return createFromStream;
                    } catch (IOException e3) {
                        new StringBuilder("Error closing icon stream for ").append(uri);
                        return createFromStream;
                    }
                } finally {
                    try {
                        openInputStream.close();
                    } catch (IOException e4) {
                        new StringBuilder("Error closing icon stream for ").append(uri);
                    }
                }
            }
        } catch (FileNotFoundException e5) {
            new StringBuilder("Icon not found: ").append(uri).append(", ").append(e5.getMessage());
            return null;
        }
    }

    private Drawable I(String str) {
        Drawable.ConstantState constantState = this.awo.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    private void a(String str, Drawable drawable) {
        if (drawable != null) {
            this.awo.put(str, drawable.getConstantState());
        }
    }

    private Drawable getActivityIcon(ComponentName componentName) {
        PackageManager packageManager = this.mContext.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            new StringBuilder("Invalid icon resource ").append(iconResource).append(" for ").append(componentName.flattenToShortString());
            return null;
        } catch (PackageManager.NameNotFoundException e2) {
            return null;
        }
    }

    public static String a(Cursor cursor, String str) {
        return a(cursor, cursor.getColumnIndex(str));
    }

    private static String a(Cursor cursor, int i2) {
        if (i2 == -1) {
            return null;
        }
        try {
            return cursor.getString(i2);
        } catch (Exception e2) {
            return null;
        }
    }

    private Drawable e(Uri uri) {
        int identifier;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: ".concat(String.valueOf(uri)));
        }
        try {
            Resources resourcesForApplication = this.mContext.getPackageManager().getResourcesForApplication(authority);
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: ".concat(String.valueOf(uri)));
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    identifier = Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException e2) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: ".concat(String.valueOf(uri)));
                }
            } else if (size == 2) {
                identifier = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
            } else {
                throw new FileNotFoundException("More than two path segments: ".concat(String.valueOf(uri)));
            }
            if (identifier != 0) {
                return resourcesForApplication.getDrawable(identifier);
            }
            throw new FileNotFoundException("No resource found for: ".concat(String.valueOf(uri)));
        } catch (PackageManager.NameNotFoundException e3) {
            throw new FileNotFoundException("No package found for authority: ".concat(String.valueOf(uri)));
        }
    }
}
