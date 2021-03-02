package com.facebook.appevents.codeless;

import android.os.Bundle;
import android.view.View;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.appevents.codeless.internal.EventBinding;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.AppEventUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public class CodelessLoggingEventListener {
    private static final String TAG = CodelessLoggingEventListener.class.getCanonicalName();

    static {
        AppMethodBeat.i(17482);
        AppMethodBeat.o(17482);
    }

    public static AutoLoggingAccessibilityDelegate getAccessibilityDelegate(EventBinding eventBinding, View view, View view2) {
        AppMethodBeat.i(17481);
        AutoLoggingAccessibilityDelegate autoLoggingAccessibilityDelegate = new AutoLoggingAccessibilityDelegate(eventBinding, view, view2);
        AppMethodBeat.o(17481);
        return autoLoggingAccessibilityDelegate;
    }

    public static class AutoLoggingAccessibilityDelegate extends View.AccessibilityDelegate {
        private int accessibilityEventType;
        private View.AccessibilityDelegate existingDelegate;
        private WeakReference<View> hostView;
        private EventBinding mapping;
        private WeakReference<View> rootView;
        protected boolean supportButtonIndexing = false;
        private boolean supportCodelessLogging = false;

        public AutoLoggingAccessibilityDelegate() {
        }

        public AutoLoggingAccessibilityDelegate(EventBinding eventBinding, View view, View view2) {
            AppMethodBeat.i(17478);
            if (eventBinding == null || view == null || view2 == null) {
                AppMethodBeat.o(17478);
                return;
            }
            this.existingDelegate = ViewHierarchy.getExistingDelegate(view2);
            this.mapping = eventBinding;
            this.hostView = new WeakReference<>(view2);
            this.rootView = new WeakReference<>(view);
            EventBinding.ActionType type = eventBinding.getType();
            switch (eventBinding.getType()) {
                case CLICK:
                    this.accessibilityEventType = 1;
                    break;
                case SELECTED:
                    this.accessibilityEventType = 4;
                    break;
                case TEXT_CHANGED:
                    this.accessibilityEventType = 16;
                    break;
                default:
                    FacebookException facebookException = new FacebookException("Unsupported action type: " + type.toString());
                    AppMethodBeat.o(17478);
                    throw facebookException;
            }
            this.supportCodelessLogging = true;
            AppMethodBeat.o(17478);
        }

        public void sendAccessibilityEvent(View view, int i2) {
            AppMethodBeat.i(17479);
            if (i2 == -1) {
                String unused = CodelessLoggingEventListener.TAG;
            }
            if (i2 != this.accessibilityEventType) {
                AppMethodBeat.o(17479);
                return;
            }
            if (this.existingDelegate != null && !(this.existingDelegate instanceof AutoLoggingAccessibilityDelegate)) {
                this.existingDelegate.sendAccessibilityEvent(view, i2);
            }
            logEvent();
            AppMethodBeat.o(17479);
        }

        private void logEvent() {
            AppMethodBeat.i(17480);
            final String eventName = this.mapping.getEventName();
            final Bundle parameters = CodelessMatcher.getParameters(this.mapping, this.rootView.get(), this.hostView.get());
            if (parameters.containsKey(AppEventsConstants.EVENT_PARAM_VALUE_TO_SUM)) {
                parameters.putDouble(AppEventsConstants.EVENT_PARAM_VALUE_TO_SUM, AppEventUtility.normalizePrice(parameters.getString(AppEventsConstants.EVENT_PARAM_VALUE_TO_SUM)));
            }
            parameters.putString(Constants.IS_CODELESS_EVENT_KEY, "1");
            FacebookSdk.getExecutor().execute(new Runnable() {
                /* class com.facebook.appevents.codeless.CodelessLoggingEventListener.AutoLoggingAccessibilityDelegate.AnonymousClass1 */

                public void run() {
                    AppMethodBeat.i(17477);
                    AppEventsLogger.newLogger(FacebookSdk.getApplicationContext()).logEvent(eventName, parameters);
                    AppMethodBeat.o(17477);
                }
            });
            AppMethodBeat.o(17480);
        }

        public boolean getSupportCodelessLogging() {
            return this.supportCodelessLogging;
        }

        public boolean getSupportButtonIndexing() {
            return this.supportButtonIndexing;
        }
    }
}
