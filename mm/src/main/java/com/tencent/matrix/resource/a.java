package com.tencent.matrix.resource;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.lang.reflect.Field;
import java.util.ArrayList;

public final class a {
    static void ch(View view) {
        LinearLayout linearLayout;
        Drawable drawable;
        FrameLayout frameLayout;
        Drawable foreground;
        ImageView imageView;
        if (!(view == null || view.getContext() == null)) {
            if (view != null) {
                try {
                    view.setOnClickListener(null);
                } catch (Throwable th) {
                }
                try {
                    view.setOnCreateContextMenuListener(null);
                } catch (Throwable th2) {
                }
                try {
                    view.setOnFocusChangeListener(null);
                } catch (Throwable th3) {
                }
                try {
                    view.setOnKeyListener(null);
                } catch (Throwable th4) {
                }
                try {
                    view.setOnLongClickListener(null);
                } catch (Throwable th5) {
                }
                try {
                    view.setOnClickListener(null);
                } catch (Throwable th6) {
                }
                try {
                    view.setOnTouchListener(null);
                } catch (Throwable th7) {
                }
                if (view.getBackground() != null) {
                    view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
                        /* class com.tencent.matrix.resource.a.AnonymousClass1 */

                        public final void onViewAttachedToWindow(View view) {
                        }

                        public final void onViewDetachedFromWindow(View view) {
                            try {
                                view.getBackground().setCallback(null);
                                view.setBackgroundDrawable(null);
                            } catch (Throwable th) {
                            }
                            try {
                                view.destroyDrawingCache();
                            } catch (Throwable th2) {
                            }
                            view.removeOnAttachStateChangeListener(this);
                        }
                    });
                }
            }
            if ((view instanceof ImageView) && (imageView = (ImageView) view) != null) {
                Drawable drawable2 = imageView.getDrawable();
                if (drawable2 != null) {
                    drawable2.setCallback(null);
                }
                imageView.setImageDrawable(null);
            }
            if (view instanceof TextView) {
                TextView textView = (TextView) view;
                Drawable[] compoundDrawables = textView.getCompoundDrawables();
                for (Drawable drawable3 : compoundDrawables) {
                    if (drawable3 != null) {
                        drawable3.setCallback(null);
                    }
                }
                textView.setCompoundDrawables(null, null, null, null);
                textView.setOnEditorActionListener(null);
                textView.setKeyListener(null);
                textView.setMovementMethod(null);
                if ((textView instanceof EditText) && textView != null) {
                    try {
                        textView.setHint("");
                        Field declaredField = TextView.class.getDeclaredField("mListeners");
                        declaredField.setAccessible(true);
                        Object obj = declaredField.get(textView);
                        if (obj instanceof ArrayList) {
                            ((ArrayList) obj).clear();
                        }
                    } catch (Throwable th8) {
                    }
                }
            }
            if (view instanceof ProgressBar) {
                ProgressBar progressBar = (ProgressBar) view;
                Drawable progressDrawable = progressBar.getProgressDrawable();
                if (progressDrawable != null) {
                    progressBar.setProgressDrawable(null);
                    progressDrawable.setCallback(null);
                }
                Drawable indeterminateDrawable = progressBar.getIndeterminateDrawable();
                if (indeterminateDrawable != null) {
                    progressBar.setIndeterminateDrawable(null);
                    indeterminateDrawable.setCallback(null);
                }
            }
            if (view instanceof ListView) {
                ListView listView = (ListView) view;
                Drawable selector = listView.getSelector();
                if (selector != null) {
                    selector.setCallback(null);
                }
                try {
                    if (listView.getAdapter() != null) {
                        listView.setAdapter((ListAdapter) null);
                    }
                } catch (Throwable th9) {
                }
                try {
                    listView.setOnScrollListener(null);
                } catch (Throwable th10) {
                }
                try {
                    listView.setOnItemClickListener(null);
                } catch (Throwable th11) {
                }
                try {
                    listView.setOnItemLongClickListener(null);
                } catch (Throwable th12) {
                }
                try {
                    listView.setOnItemSelectedListener(null);
                } catch (Throwable th13) {
                }
            }
            if (!(!(view instanceof FrameLayout) || (frameLayout = (FrameLayout) view) == null || (foreground = frameLayout.getForeground()) == null)) {
                foreground.setCallback(null);
                frameLayout.setForeground(null);
            }
            if ((view instanceof LinearLayout) && (linearLayout = (LinearLayout) view) != null && 11 <= Build.VERSION.SDK_INT) {
                if (16 <= Build.VERSION.SDK_INT) {
                    drawable = linearLayout.getDividerDrawable();
                } else {
                    try {
                        Field declaredField2 = linearLayout.getClass().getDeclaredField("mDivider");
                        declaredField2.setAccessible(true);
                        drawable = (Drawable) declaredField2.get(linearLayout);
                    } catch (Throwable th14) {
                        drawable = null;
                    }
                }
                if (drawable != null) {
                    drawable.setCallback(null);
                    linearLayout.setDividerDrawable(null);
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    ch(viewGroup.getChildAt(i2));
                }
            }
        }
    }
}
