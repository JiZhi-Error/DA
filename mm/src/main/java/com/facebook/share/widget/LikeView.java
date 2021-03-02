package com.facebook.share.widget;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.d;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.FacebookException;
import com.facebook.common.R;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.share.internal.LikeActionController;
import com.facebook.share.internal.LikeBoxCountView;
import com.facebook.share.internal.LikeButton;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public class LikeView extends FrameLayout {
    private static final int NO_FOREGROUND_COLOR = -1;
    private AuxiliaryViewPosition auxiliaryViewPosition = AuxiliaryViewPosition.DEFAULT;
    private BroadcastReceiver broadcastReceiver;
    private LinearLayout containerView;
    private LikeActionControllerCreationCallback creationCallback;
    private int edgePadding;
    private boolean explicitlyDisabled = true;
    private int foregroundColor = -1;
    private HorizontalAlignment horizontalAlignment = HorizontalAlignment.DEFAULT;
    private int internalPadding;
    private LikeActionController likeActionController;
    private LikeBoxCountView likeBoxCountView;
    private LikeButton likeButton;
    private Style likeViewStyle = Style.DEFAULT;
    private String objectId;
    private ObjectType objectType;
    private OnErrorListener onErrorListener;
    private FragmentWrapper parentFragment;
    private TextView socialSentenceView;

    public interface OnErrorListener {
        void onError(FacebookException facebookException);
    }

    static /* synthetic */ void access$1000(LikeView likeView, String str, ObjectType objectType2) {
        AppMethodBeat.i(8698);
        likeView.setObjectIdAndTypeForced(str, objectType2);
        AppMethodBeat.o(8698);
    }

    static /* synthetic */ void access$1100(LikeView likeView, LikeActionController likeActionController2) {
        AppMethodBeat.i(8699);
        likeView.associateWithLikeActionController(likeActionController2);
        AppMethodBeat.o(8699);
    }

    static /* synthetic */ void access$300(LikeView likeView) {
        AppMethodBeat.i(8696);
        likeView.toggleLike();
        AppMethodBeat.o(8696);
    }

    static /* synthetic */ void access$700(LikeView likeView) {
        AppMethodBeat.i(8697);
        likeView.updateLikeStateAndLayout();
        AppMethodBeat.o(8697);
    }

    @Deprecated
    public enum ObjectType {
        UNKNOWN("unknown", 0),
        OPEN_GRAPH("open_graph", 1),
        PAGE("page", 2);
        
        public static ObjectType DEFAULT = UNKNOWN;
        private int intValue;
        private String stringValue;

        public static ObjectType valueOf(String str) {
            AppMethodBeat.i(8663);
            ObjectType objectType = (ObjectType) Enum.valueOf(ObjectType.class, str);
            AppMethodBeat.o(8663);
            return objectType;
        }

        static {
            AppMethodBeat.i(8665);
            AppMethodBeat.o(8665);
        }

        public static ObjectType fromInt(int i2) {
            AppMethodBeat.i(8664);
            ObjectType[] values = values();
            for (ObjectType objectType : values) {
                if (objectType.getValue() == i2) {
                    AppMethodBeat.o(8664);
                    return objectType;
                }
            }
            AppMethodBeat.o(8664);
            return null;
        }

        private ObjectType(String str, int i2) {
            this.stringValue = str;
            this.intValue = i2;
        }

        public final String toString() {
            return this.stringValue;
        }

        public final int getValue() {
            return this.intValue;
        }
    }

    @Deprecated
    public enum Style {
        STANDARD("standard", 0),
        BUTTON("button", 1),
        BOX_COUNT("box_count", 2);
        
        static Style DEFAULT = STANDARD;
        private int intValue;
        private String stringValue;

        public static Style valueOf(String str) {
            AppMethodBeat.i(8667);
            Style style = (Style) Enum.valueOf(Style.class, str);
            AppMethodBeat.o(8667);
            return style;
        }

        static /* synthetic */ int access$000(Style style) {
            AppMethodBeat.i(8669);
            int value = style.getValue();
            AppMethodBeat.o(8669);
            return value;
        }

        static {
            AppMethodBeat.i(8670);
            AppMethodBeat.o(8670);
        }

        static Style fromInt(int i2) {
            AppMethodBeat.i(8668);
            Style[] values = values();
            for (Style style : values) {
                if (style.getValue() == i2) {
                    AppMethodBeat.o(8668);
                    return style;
                }
            }
            AppMethodBeat.o(8668);
            return null;
        }

        private Style(String str, int i2) {
            this.stringValue = str;
            this.intValue = i2;
        }

        public final String toString() {
            return this.stringValue;
        }

        private int getValue() {
            return this.intValue;
        }
    }

    @Deprecated
    public enum HorizontalAlignment {
        CENTER("center", 0),
        LEFT("left", 1),
        RIGHT("right", 2);
        
        static HorizontalAlignment DEFAULT = CENTER;
        private int intValue;
        private String stringValue;

        public static HorizontalAlignment valueOf(String str) {
            AppMethodBeat.i(8656);
            HorizontalAlignment horizontalAlignment = (HorizontalAlignment) Enum.valueOf(HorizontalAlignment.class, str);
            AppMethodBeat.o(8656);
            return horizontalAlignment;
        }

        static /* synthetic */ int access$200(HorizontalAlignment horizontalAlignment) {
            AppMethodBeat.i(8658);
            int value = horizontalAlignment.getValue();
            AppMethodBeat.o(8658);
            return value;
        }

        static {
            AppMethodBeat.i(8659);
            AppMethodBeat.o(8659);
        }

        static HorizontalAlignment fromInt(int i2) {
            AppMethodBeat.i(8657);
            HorizontalAlignment[] values = values();
            for (HorizontalAlignment horizontalAlignment : values) {
                if (horizontalAlignment.getValue() == i2) {
                    AppMethodBeat.o(8657);
                    return horizontalAlignment;
                }
            }
            AppMethodBeat.o(8657);
            return null;
        }

        private HorizontalAlignment(String str, int i2) {
            this.stringValue = str;
            this.intValue = i2;
        }

        public final String toString() {
            return this.stringValue;
        }

        private int getValue() {
            return this.intValue;
        }
    }

    @Deprecated
    public enum AuxiliaryViewPosition {
        BOTTOM("bottom", 0),
        INLINE("inline", 1),
        TOP("top", 2);
        
        static AuxiliaryViewPosition DEFAULT = BOTTOM;
        private int intValue;
        private String stringValue;

        public static AuxiliaryViewPosition valueOf(String str) {
            AppMethodBeat.i(8651);
            AuxiliaryViewPosition auxiliaryViewPosition = (AuxiliaryViewPosition) Enum.valueOf(AuxiliaryViewPosition.class, str);
            AppMethodBeat.o(8651);
            return auxiliaryViewPosition;
        }

        static /* synthetic */ int access$100(AuxiliaryViewPosition auxiliaryViewPosition) {
            AppMethodBeat.i(8653);
            int value = auxiliaryViewPosition.getValue();
            AppMethodBeat.o(8653);
            return value;
        }

        static {
            AppMethodBeat.i(8654);
            AppMethodBeat.o(8654);
        }

        static AuxiliaryViewPosition fromInt(int i2) {
            AppMethodBeat.i(8652);
            AuxiliaryViewPosition[] values = values();
            for (AuxiliaryViewPosition auxiliaryViewPosition : values) {
                if (auxiliaryViewPosition.getValue() == i2) {
                    AppMethodBeat.o(8652);
                    return auxiliaryViewPosition;
                }
            }
            AppMethodBeat.o(8652);
            return null;
        }

        private AuxiliaryViewPosition(String str, int i2) {
            this.stringValue = str;
            this.intValue = i2;
        }

        public final String toString() {
            return this.stringValue;
        }

        private int getValue() {
            return this.intValue;
        }
    }

    @Deprecated
    public LikeView(Context context) {
        super(context);
        AppMethodBeat.i(8671);
        initialize(context);
        AppMethodBeat.o(8671);
    }

    @Deprecated
    public LikeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(8672);
        parseAttributes(attributeSet);
        initialize(context);
        AppMethodBeat.o(8672);
    }

    @Deprecated
    public void setObjectIdAndType(String str, ObjectType objectType2) {
        AppMethodBeat.i(8673);
        String coerceValueIfNullOrEmpty = Utility.coerceValueIfNullOrEmpty(str, null);
        if (objectType2 == null) {
            objectType2 = ObjectType.DEFAULT;
        }
        if (!Utility.areObjectsEqual(coerceValueIfNullOrEmpty, this.objectId) || objectType2 != this.objectType) {
            setObjectIdAndTypeForced(coerceValueIfNullOrEmpty, objectType2);
            updateLikeStateAndLayout();
        }
        AppMethodBeat.o(8673);
    }

    @Deprecated
    public void setLikeViewStyle(Style style) {
        AppMethodBeat.i(8674);
        if (style == null) {
            style = Style.DEFAULT;
        }
        if (this.likeViewStyle != style) {
            this.likeViewStyle = style;
            updateLayout();
        }
        AppMethodBeat.o(8674);
    }

    @Deprecated
    public void setAuxiliaryViewPosition(AuxiliaryViewPosition auxiliaryViewPosition2) {
        AppMethodBeat.i(8675);
        if (auxiliaryViewPosition2 == null) {
            auxiliaryViewPosition2 = AuxiliaryViewPosition.DEFAULT;
        }
        if (this.auxiliaryViewPosition != auxiliaryViewPosition2) {
            this.auxiliaryViewPosition = auxiliaryViewPosition2;
            updateLayout();
        }
        AppMethodBeat.o(8675);
    }

    @Deprecated
    public void setHorizontalAlignment(HorizontalAlignment horizontalAlignment2) {
        AppMethodBeat.i(8676);
        if (horizontalAlignment2 == null) {
            horizontalAlignment2 = HorizontalAlignment.DEFAULT;
        }
        if (this.horizontalAlignment != horizontalAlignment2) {
            this.horizontalAlignment = horizontalAlignment2;
            updateLayout();
        }
        AppMethodBeat.o(8676);
    }

    @Deprecated
    public void setForegroundColor(int i2) {
        AppMethodBeat.i(8677);
        if (this.foregroundColor != i2) {
            this.socialSentenceView.setTextColor(i2);
        }
        AppMethodBeat.o(8677);
    }

    @Deprecated
    public void setOnErrorListener(OnErrorListener onErrorListener2) {
        this.onErrorListener = onErrorListener2;
    }

    @Deprecated
    public OnErrorListener getOnErrorListener() {
        return this.onErrorListener;
    }

    @Deprecated
    public void setFragment(Fragment fragment) {
        AppMethodBeat.i(8678);
        this.parentFragment = new FragmentWrapper(fragment);
        AppMethodBeat.o(8678);
    }

    @Deprecated
    public void setFragment(android.app.Fragment fragment) {
        AppMethodBeat.i(8679);
        this.parentFragment = new FragmentWrapper(fragment);
        AppMethodBeat.o(8679);
    }

    @Deprecated
    public void setEnabled(boolean z) {
        AppMethodBeat.i(8680);
        this.explicitlyDisabled = true;
        updateLikeStateAndLayout();
        AppMethodBeat.o(8680);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(8681);
        setObjectIdAndType(null, ObjectType.UNKNOWN);
        super.onDetachedFromWindow();
        AppMethodBeat.o(8681);
    }

    private void parseAttributes(AttributeSet attributeSet) {
        AppMethodBeat.i(8682);
        if (attributeSet == null || getContext() == null) {
            AppMethodBeat.o(8682);
            return;
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.com_facebook_like_view);
        if (obtainStyledAttributes == null) {
            AppMethodBeat.o(8682);
            return;
        }
        this.objectId = Utility.coerceValueIfNullOrEmpty(obtainStyledAttributes.getString(3), null);
        this.objectType = ObjectType.fromInt(obtainStyledAttributes.getInt(4, ObjectType.DEFAULT.getValue()));
        this.likeViewStyle = Style.fromInt(obtainStyledAttributes.getInt(5, Style.access$000(Style.DEFAULT)));
        if (this.likeViewStyle == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unsupported value for LikeView 'style'");
            AppMethodBeat.o(8682);
            throw illegalArgumentException;
        }
        this.auxiliaryViewPosition = AuxiliaryViewPosition.fromInt(obtainStyledAttributes.getInt(0, AuxiliaryViewPosition.access$100(AuxiliaryViewPosition.DEFAULT)));
        if (this.auxiliaryViewPosition == null) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Unsupported value for LikeView 'auxiliary_view_position'");
            AppMethodBeat.o(8682);
            throw illegalArgumentException2;
        }
        this.horizontalAlignment = HorizontalAlignment.fromInt(obtainStyledAttributes.getInt(2, HorizontalAlignment.access$200(HorizontalAlignment.DEFAULT)));
        if (this.horizontalAlignment == null) {
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Unsupported value for LikeView 'horizontal_alignment'");
            AppMethodBeat.o(8682);
            throw illegalArgumentException3;
        }
        this.foregroundColor = obtainStyledAttributes.getColor(1, -1);
        obtainStyledAttributes.recycle();
        AppMethodBeat.o(8682);
    }

    private void initialize(Context context) {
        AppMethodBeat.i(8683);
        this.edgePadding = getResources().getDimensionPixelSize(com.tencent.mm.R.dimen.xw);
        this.internalPadding = getResources().getDimensionPixelSize(com.tencent.mm.R.dimen.xx);
        if (this.foregroundColor == -1) {
            this.foregroundColor = getResources().getColor(com.tencent.mm.R.color.k6);
        }
        setBackgroundColor(0);
        this.containerView = new LinearLayout(context);
        this.containerView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        initializeLikeButton(context);
        initializeSocialSentenceView(context);
        initializeLikeCountView(context);
        this.containerView.addView(this.likeButton);
        this.containerView.addView(this.socialSentenceView);
        this.containerView.addView(this.likeBoxCountView);
        addView(this.containerView);
        setObjectIdAndTypeForced(this.objectId, this.objectType);
        updateLikeStateAndLayout();
        AppMethodBeat.o(8683);
    }

    private void initializeLikeButton(Context context) {
        AppMethodBeat.i(8684);
        this.likeButton = new LikeButton(context, this.likeActionController != null && this.likeActionController.isObjectLiked());
        this.likeButton.setOnClickListener(new View.OnClickListener() {
            /* class com.facebook.share.widget.LikeView.AnonymousClass1 */

            public void onClick(View view) {
                AppMethodBeat.i(8648);
                LikeView.access$300(LikeView.this);
                AppMethodBeat.o(8648);
            }
        });
        this.likeButton.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        AppMethodBeat.o(8684);
    }

    private void initializeSocialSentenceView(Context context) {
        AppMethodBeat.i(8685);
        this.socialSentenceView = new TextView(context);
        this.socialSentenceView.setTextSize(0, getResources().getDimension(com.tencent.mm.R.dimen.xy));
        this.socialSentenceView.setMaxLines(2);
        this.socialSentenceView.setTextColor(this.foregroundColor);
        this.socialSentenceView.setGravity(17);
        this.socialSentenceView.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        AppMethodBeat.o(8685);
    }

    private void initializeLikeCountView(Context context) {
        AppMethodBeat.i(8686);
        this.likeBoxCountView = new LikeBoxCountView(context);
        this.likeBoxCountView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        AppMethodBeat.o(8686);
    }

    private void toggleLike() {
        AppMethodBeat.i(8687);
        if (this.likeActionController != null) {
            Activity activity = null;
            if (this.parentFragment == null) {
                activity = getActivity();
            }
            this.likeActionController.toggleLike(activity, this.parentFragment, getAnalyticsParameters());
        }
        AppMethodBeat.o(8687);
    }

    private Activity getActivity() {
        AppMethodBeat.i(8688);
        Context context = getContext();
        while (!(context instanceof Activity) && (context instanceof ContextWrapper)) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            AppMethodBeat.o(8688);
            return activity;
        }
        FacebookException facebookException = new FacebookException("Unable to get Activity.");
        AppMethodBeat.o(8688);
        throw facebookException;
    }

    private Bundle getAnalyticsParameters() {
        AppMethodBeat.i(8689);
        Bundle bundle = new Bundle();
        bundle.putString(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, this.likeViewStyle.toString());
        bundle.putString(AnalyticsEvents.PARAMETER_LIKE_VIEW_AUXILIARY_POSITION, this.auxiliaryViewPosition.toString());
        bundle.putString(AnalyticsEvents.PARAMETER_LIKE_VIEW_HORIZONTAL_ALIGNMENT, this.horizontalAlignment.toString());
        bundle.putString("object_id", Utility.coerceValueIfNullOrEmpty(this.objectId, ""));
        bundle.putString("object_type", this.objectType.toString());
        AppMethodBeat.o(8689);
        return bundle;
    }

    private void setObjectIdAndTypeForced(String str, ObjectType objectType2) {
        AppMethodBeat.i(8690);
        tearDownObjectAssociations();
        this.objectId = str;
        this.objectType = objectType2;
        if (Utility.isNullOrEmpty(str)) {
            AppMethodBeat.o(8690);
            return;
        }
        this.creationCallback = new LikeActionControllerCreationCallback();
        if (!isInEditMode()) {
            LikeActionController.getControllerForObjectId(str, objectType2, this.creationCallback);
        }
        AppMethodBeat.o(8690);
    }

    private void associateWithLikeActionController(LikeActionController likeActionController2) {
        AppMethodBeat.i(8691);
        this.likeActionController = likeActionController2;
        this.broadcastReceiver = new LikeControllerBroadcastReceiver();
        d W = d.W(getContext());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_UPDATED);
        intentFilter.addAction(LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_DID_ERROR);
        intentFilter.addAction(LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_DID_RESET);
        W.a(this.broadcastReceiver, intentFilter);
        AppMethodBeat.o(8691);
    }

    private void tearDownObjectAssociations() {
        AppMethodBeat.i(8692);
        if (this.broadcastReceiver != null) {
            d.W(getContext()).unregisterReceiver(this.broadcastReceiver);
            this.broadcastReceiver = null;
        }
        if (this.creationCallback != null) {
            this.creationCallback.cancel();
            this.creationCallback = null;
        }
        this.likeActionController = null;
        AppMethodBeat.o(8692);
    }

    private void updateLikeStateAndLayout() {
        AppMethodBeat.i(8693);
        boolean z = !this.explicitlyDisabled;
        if (this.likeActionController == null) {
            this.likeButton.setSelected(false);
            this.socialSentenceView.setText((CharSequence) null);
            this.likeBoxCountView.setText(null);
        } else {
            this.likeButton.setSelected(this.likeActionController.isObjectLiked());
            this.socialSentenceView.setText(this.likeActionController.getSocialSentence());
            this.likeBoxCountView.setText(this.likeActionController.getLikeCountString());
            z &= this.likeActionController.shouldEnableView();
        }
        super.setEnabled(z);
        this.likeButton.setEnabled(z);
        updateLayout();
        AppMethodBeat.o(8693);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private void updateLayout() {
        int i2;
        View view;
        int i3 = 1;
        AppMethodBeat.i(8694);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.containerView.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.likeButton.getLayoutParams();
        if (this.horizontalAlignment == HorizontalAlignment.LEFT) {
            i2 = 3;
        } else {
            i2 = this.horizontalAlignment == HorizontalAlignment.CENTER ? 1 : 5;
        }
        layoutParams.gravity = i2 | 48;
        layoutParams2.gravity = i2;
        this.socialSentenceView.setVisibility(8);
        this.likeBoxCountView.setVisibility(8);
        if (this.likeViewStyle == Style.STANDARD && this.likeActionController != null && !Utility.isNullOrEmpty(this.likeActionController.getSocialSentence())) {
            view = this.socialSentenceView;
        } else if (this.likeViewStyle != Style.BOX_COUNT || this.likeActionController == null || Utility.isNullOrEmpty(this.likeActionController.getLikeCountString())) {
            AppMethodBeat.o(8694);
            return;
        } else {
            updateBoxCountCaretPosition();
            view = this.likeBoxCountView;
        }
        view.setVisibility(0);
        ((LinearLayout.LayoutParams) view.getLayoutParams()).gravity = i2;
        LinearLayout linearLayout = this.containerView;
        if (this.auxiliaryViewPosition == AuxiliaryViewPosition.INLINE) {
            i3 = 0;
        }
        linearLayout.setOrientation(i3);
        if (this.auxiliaryViewPosition == AuxiliaryViewPosition.TOP || (this.auxiliaryViewPosition == AuxiliaryViewPosition.INLINE && this.horizontalAlignment == HorizontalAlignment.RIGHT)) {
            this.containerView.removeView(this.likeButton);
            this.containerView.addView(this.likeButton);
        } else {
            this.containerView.removeView(view);
            this.containerView.addView(view);
        }
        switch (this.auxiliaryViewPosition) {
            case TOP:
                view.setPadding(this.edgePadding, this.edgePadding, this.edgePadding, this.internalPadding);
                AppMethodBeat.o(8694);
                return;
            case BOTTOM:
                view.setPadding(this.edgePadding, this.internalPadding, this.edgePadding, this.edgePadding);
                AppMethodBeat.o(8694);
                return;
            case INLINE:
                if (this.horizontalAlignment != HorizontalAlignment.RIGHT) {
                    view.setPadding(this.internalPadding, this.edgePadding, this.edgePadding, this.edgePadding);
                    break;
                } else {
                    view.setPadding(this.edgePadding, this.edgePadding, this.internalPadding, this.edgePadding);
                    AppMethodBeat.o(8694);
                    return;
                }
        }
        AppMethodBeat.o(8694);
    }

    private void updateBoxCountCaretPosition() {
        LikeBoxCountView likeBoxCountView2;
        LikeBoxCountView.LikeBoxCountViewCaretPosition likeBoxCountViewCaretPosition;
        AppMethodBeat.i(8695);
        switch (this.auxiliaryViewPosition) {
            case TOP:
                likeBoxCountView2 = this.likeBoxCountView;
                likeBoxCountViewCaretPosition = LikeBoxCountView.LikeBoxCountViewCaretPosition.BOTTOM;
                likeBoxCountView2.setCaretPosition(likeBoxCountViewCaretPosition);
                break;
            case BOTTOM:
                likeBoxCountView2 = this.likeBoxCountView;
                likeBoxCountViewCaretPosition = LikeBoxCountView.LikeBoxCountViewCaretPosition.TOP;
                likeBoxCountView2.setCaretPosition(likeBoxCountViewCaretPosition);
                break;
            case INLINE:
                likeBoxCountView2 = this.likeBoxCountView;
                likeBoxCountViewCaretPosition = this.horizontalAlignment == HorizontalAlignment.RIGHT ? LikeBoxCountView.LikeBoxCountViewCaretPosition.RIGHT : LikeBoxCountView.LikeBoxCountViewCaretPosition.LEFT;
                likeBoxCountView2.setCaretPosition(likeBoxCountViewCaretPosition);
                break;
        }
        AppMethodBeat.o(8695);
    }

    /* access modifiers changed from: package-private */
    public class LikeControllerBroadcastReceiver extends BroadcastReceiver {
        private LikeControllerBroadcastReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            boolean z = true;
            AppMethodBeat.i(8661);
            String action = intent.getAction();
            Bundle extras = intent.getExtras();
            if (extras != null) {
                String string = extras.getString(LikeActionController.ACTION_OBJECT_ID_KEY);
                if (!Utility.isNullOrEmpty(string) && !Utility.areObjectsEqual(LikeView.this.objectId, string)) {
                    z = false;
                }
            }
            if (!z) {
                AppMethodBeat.o(8661);
            } else if (LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_UPDATED.equals(action)) {
                LikeView.access$700(LikeView.this);
                AppMethodBeat.o(8661);
            } else {
                if (LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_DID_ERROR.equals(action)) {
                    if (LikeView.this.onErrorListener != null) {
                        LikeView.this.onErrorListener.onError(NativeProtocol.getExceptionFromErrorData(extras));
                        AppMethodBeat.o(8661);
                        return;
                    }
                } else if (LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_DID_RESET.equals(action)) {
                    LikeView.access$1000(LikeView.this, LikeView.this.objectId, LikeView.this.objectType);
                    LikeView.access$700(LikeView.this);
                }
                AppMethodBeat.o(8661);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class LikeActionControllerCreationCallback implements LikeActionController.CreationCallback {
        private boolean isCancelled;

        private LikeActionControllerCreationCallback() {
        }

        public void cancel() {
            this.isCancelled = true;
        }

        @Override // com.facebook.share.internal.LikeActionController.CreationCallback
        public void onComplete(LikeActionController likeActionController, FacebookException facebookException) {
            AppMethodBeat.i(8660);
            if (this.isCancelled) {
                AppMethodBeat.o(8660);
                return;
            }
            if (likeActionController != null) {
                if (!likeActionController.shouldEnableView()) {
                    facebookException = new FacebookException("Cannot use LikeView. The device may not be supported.");
                }
                LikeView.access$1100(LikeView.this, likeActionController);
                LikeView.access$700(LikeView.this);
            }
            if (!(facebookException == null || LikeView.this.onErrorListener == null)) {
                LikeView.this.onErrorListener.onError(facebookException);
            }
            LikeView.this.creationCallback = null;
            AppMethodBeat.o(8660);
        }
    }
}
