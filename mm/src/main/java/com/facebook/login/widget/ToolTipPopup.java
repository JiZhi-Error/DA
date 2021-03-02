package com.facebook.login.widget;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import java.lang.ref.WeakReference;

public class ToolTipPopup {
    public static final long DEFAULT_POPUP_DISPLAY_TIME = 6000;
    private final WeakReference<View> mAnchorViewRef;
    private final Context mContext;
    private long mNuxDisplayTime = DEFAULT_POPUP_DISPLAY_TIME;
    private PopupContentView mPopupContent;
    private PopupWindow mPopupWindow;
    private final ViewTreeObserver.OnScrollChangedListener mScrollListener = new ViewTreeObserver.OnScrollChangedListener() {
        /* class com.facebook.login.widget.ToolTipPopup.AnonymousClass1 */

        public void onScrollChanged() {
            AppMethodBeat.i(40478);
            if (!(ToolTipPopup.this.mAnchorViewRef.get() == null || ToolTipPopup.this.mPopupWindow == null || !ToolTipPopup.this.mPopupWindow.isShowing())) {
                if (ToolTipPopup.this.mPopupWindow.isAboveAnchor()) {
                    ToolTipPopup.this.mPopupContent.showBottomArrow();
                    AppMethodBeat.o(40478);
                    return;
                }
                ToolTipPopup.this.mPopupContent.showTopArrow();
            }
            AppMethodBeat.o(40478);
        }
    };
    private Style mStyle = Style.BLUE;
    private final String mText;

    public enum Style {
        BLUE,
        BLACK;

        public static Style valueOf(String str) {
            AppMethodBeat.i(40486);
            Style style = (Style) Enum.valueOf(Style.class, str);
            AppMethodBeat.o(40486);
            return style;
        }

        static {
            AppMethodBeat.i(40487);
            AppMethodBeat.o(40487);
        }
    }

    public ToolTipPopup(String str, View view) {
        AppMethodBeat.i(40488);
        this.mText = str;
        this.mAnchorViewRef = new WeakReference<>(view);
        this.mContext = view.getContext();
        AppMethodBeat.o(40488);
    }

    public void setStyle(Style style) {
        this.mStyle = style;
    }

    public void show() {
        AppMethodBeat.i(40489);
        if (this.mAnchorViewRef.get() != null) {
            this.mPopupContent = new PopupContentView(this.mContext);
            ((TextView) this.mPopupContent.findViewById(R.id.b8a)).setText(this.mText);
            if (this.mStyle == Style.BLUE) {
                this.mPopupContent.bodyFrame.setBackgroundResource(R.drawable.b8r);
                this.mPopupContent.bottomArrow.setImageResource(R.drawable.b8s);
                this.mPopupContent.topArrow.setImageResource(R.drawable.b8t);
                this.mPopupContent.xOut.setImageResource(R.drawable.b8u);
            } else {
                this.mPopupContent.bodyFrame.setBackgroundResource(R.drawable.b8n);
                this.mPopupContent.bottomArrow.setImageResource(R.drawable.b8o);
                this.mPopupContent.topArrow.setImageResource(R.drawable.b8p);
                this.mPopupContent.xOut.setImageResource(R.drawable.b8q);
            }
            View decorView = ((Activity) this.mContext).getWindow().getDecorView();
            int width = decorView.getWidth();
            int height = decorView.getHeight();
            registerObserver();
            this.mPopupContent.measure(View.MeasureSpec.makeMeasureSpec(width, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(height, Integer.MIN_VALUE));
            this.mPopupWindow = new PopupWindow(this.mPopupContent, this.mPopupContent.getMeasuredWidth(), this.mPopupContent.getMeasuredHeight());
            this.mPopupWindow.showAsDropDown(this.mAnchorViewRef.get());
            updateArrows();
            if (this.mNuxDisplayTime > 0) {
                this.mPopupContent.postDelayed(new Runnable() {
                    /* class com.facebook.login.widget.ToolTipPopup.AnonymousClass2 */

                    public void run() {
                        AppMethodBeat.i(40479);
                        ToolTipPopup.this.dismiss();
                        AppMethodBeat.o(40479);
                    }
                }, this.mNuxDisplayTime);
            }
            this.mPopupWindow.setTouchable(true);
            this.mPopupContent.setOnClickListener(new View.OnClickListener() {
                /* class com.facebook.login.widget.ToolTipPopup.AnonymousClass3 */

                public void onClick(View view) {
                    AppMethodBeat.i(40480);
                    ToolTipPopup.this.dismiss();
                    AppMethodBeat.o(40480);
                }
            });
        }
        AppMethodBeat.o(40489);
    }

    public void setNuxDisplayTime(long j2) {
        this.mNuxDisplayTime = j2;
    }

    private void updateArrows() {
        AppMethodBeat.i(40490);
        if (this.mPopupWindow != null && this.mPopupWindow.isShowing()) {
            if (this.mPopupWindow.isAboveAnchor()) {
                this.mPopupContent.showBottomArrow();
                AppMethodBeat.o(40490);
                return;
            }
            this.mPopupContent.showTopArrow();
        }
        AppMethodBeat.o(40490);
    }

    public void dismiss() {
        AppMethodBeat.i(40491);
        unregisterObserver();
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
        }
        AppMethodBeat.o(40491);
    }

    private void registerObserver() {
        AppMethodBeat.i(40492);
        unregisterObserver();
        if (this.mAnchorViewRef.get() != null) {
            this.mAnchorViewRef.get().getViewTreeObserver().addOnScrollChangedListener(this.mScrollListener);
        }
        AppMethodBeat.o(40492);
    }

    private void unregisterObserver() {
        AppMethodBeat.i(40493);
        if (this.mAnchorViewRef.get() != null) {
            this.mAnchorViewRef.get().getViewTreeObserver().removeOnScrollChangedListener(this.mScrollListener);
        }
        AppMethodBeat.o(40493);
    }

    /* access modifiers changed from: package-private */
    public class PopupContentView extends FrameLayout {
        private View bodyFrame;
        private ImageView bottomArrow;
        private ImageView topArrow;
        private ImageView xOut;

        public PopupContentView(Context context) {
            super(context);
            AppMethodBeat.i(40481);
            init();
            AppMethodBeat.o(40481);
        }

        private void init() {
            AppMethodBeat.i(40482);
            LayoutInflater.from(getContext()).inflate(R.layout.vj, this);
            this.topArrow = (ImageView) findViewById(R.id.b8b);
            this.bottomArrow = (ImageView) findViewById(R.id.b8_);
            this.bodyFrame = findViewById(R.id.b83);
            this.xOut = (ImageView) findViewById(R.id.b84);
            AppMethodBeat.o(40482);
        }

        public void showTopArrow() {
            AppMethodBeat.i(40483);
            this.topArrow.setVisibility(0);
            this.bottomArrow.setVisibility(4);
            AppMethodBeat.o(40483);
        }

        public void showBottomArrow() {
            AppMethodBeat.i(40484);
            this.topArrow.setVisibility(4);
            this.bottomArrow.setVisibility(0);
            AppMethodBeat.o(40484);
        }
    }
}
