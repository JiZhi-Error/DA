package com.facebook.appevents.codeless;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.codeless.CodelessLoggingEventListener;
import com.facebook.appevents.codeless.RCTCodelessLoggingEventListener;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.appevents.codeless.internal.EventBinding;
import com.facebook.appevents.codeless.internal.ParameterComponent;
import com.facebook.appevents.codeless.internal.PathComponent;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.InternalSettings;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CodelessMatcher {
    private static final String CURRENT_CLASS_NAME = ".";
    private static final String PARENT_CLASS_NAME = "..";
    private static final String TAG = CodelessMatcher.class.getCanonicalName();
    private Set<Activity> activitiesSet = new HashSet();
    private HashMap<String, String> delegateMap = new HashMap<>();
    private final Handler uiThreadHandler = new Handler(Looper.getMainLooper());
    private Set<ViewMatcher> viewMatchers = new HashSet();

    static /* synthetic */ void access$000(CodelessMatcher codelessMatcher) {
        AppMethodBeat.i(17503);
        codelessMatcher.matchViews();
        AppMethodBeat.o(17503);
    }

    static {
        AppMethodBeat.i(17504);
        AppMethodBeat.o(17504);
    }

    public CodelessMatcher() {
        AppMethodBeat.i(17497);
        AppMethodBeat.o(17497);
    }

    public void add(Activity activity) {
        AppMethodBeat.i(17498);
        if (InternalSettings.isUnityApp()) {
            AppMethodBeat.o(17498);
        } else if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            FacebookException facebookException = new FacebookException("Can't add activity to CodelessMatcher on non-UI thread");
            AppMethodBeat.o(17498);
            throw facebookException;
        } else {
            this.activitiesSet.add(activity);
            this.delegateMap.clear();
            startTracking();
            AppMethodBeat.o(17498);
        }
    }

    public void remove(Activity activity) {
        AppMethodBeat.i(17499);
        if (InternalSettings.isUnityApp()) {
            AppMethodBeat.o(17499);
        } else if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            FacebookException facebookException = new FacebookException("Can't remove activity from CodelessMatcher on non-UI thread");
            AppMethodBeat.o(17499);
            throw facebookException;
        } else {
            this.activitiesSet.remove(activity);
            this.viewMatchers.clear();
            this.delegateMap.clear();
            AppMethodBeat.o(17499);
        }
    }

    public static Bundle getParameters(EventBinding eventBinding, View view, View view2) {
        List<MatchedView> findViewByPath;
        AppMethodBeat.i(17500);
        Bundle bundle = new Bundle();
        if (eventBinding == null) {
            AppMethodBeat.o(17500);
            return bundle;
        }
        List<ParameterComponent> viewParameters = eventBinding.getViewParameters();
        if (viewParameters != null) {
            for (ParameterComponent parameterComponent : viewParameters) {
                if (parameterComponent.value != null && parameterComponent.value.length() > 0) {
                    bundle.putString(parameterComponent.name, parameterComponent.value);
                } else if (parameterComponent.path.size() > 0) {
                    if (parameterComponent.pathType.equals(Constants.PATH_TYPE_RELATIVE)) {
                        findViewByPath = ViewMatcher.findViewByPath(eventBinding, view2, parameterComponent.path, 0, -1, view2.getClass().getSimpleName());
                    } else {
                        findViewByPath = ViewMatcher.findViewByPath(eventBinding, view, parameterComponent.path, 0, -1, view.getClass().getSimpleName());
                    }
                    Iterator<MatchedView> it = findViewByPath.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MatchedView next = it.next();
                        if (next.getView() != null) {
                            String textOfView = ViewHierarchy.getTextOfView(next.getView());
                            if (textOfView.length() > 0) {
                                bundle.putString(parameterComponent.name, textOfView);
                                break;
                            }
                        }
                    }
                }
            }
        }
        AppMethodBeat.o(17500);
        return bundle;
    }

    private void startTracking() {
        AppMethodBeat.i(17501);
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            matchViews();
            AppMethodBeat.o(17501);
            return;
        }
        this.uiThreadHandler.post(new Runnable() {
            /* class com.facebook.appevents.codeless.CodelessMatcher.AnonymousClass1 */

            public void run() {
                AppMethodBeat.i(17483);
                CodelessMatcher.access$000(CodelessMatcher.this);
                AppMethodBeat.o(17483);
            }
        });
        AppMethodBeat.o(17501);
    }

    private void matchViews() {
        AppMethodBeat.i(17502);
        for (Activity activity : this.activitiesSet) {
            this.viewMatchers.add(new ViewMatcher(activity.getWindow().getDecorView().getRootView(), this.uiThreadHandler, this.delegateMap, activity.getClass().getSimpleName()));
        }
        AppMethodBeat.o(17502);
    }

    public static class MatchedView {
        private WeakReference<View> view;
        private String viewMapKey;

        public MatchedView(View view2, String str) {
            AppMethodBeat.i(17484);
            this.view = new WeakReference<>(view2);
            this.viewMapKey = str;
            AppMethodBeat.o(17484);
        }

        public View getView() {
            AppMethodBeat.i(17485);
            if (this.view == null) {
                AppMethodBeat.o(17485);
                return null;
            }
            View view2 = this.view.get();
            AppMethodBeat.o(17485);
            return view2;
        }

        public String getViewMapKey() {
            return this.viewMapKey;
        }
    }

    /* access modifiers changed from: protected */
    public static class ViewMatcher implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, Runnable {
        private final String activityName;
        private HashMap<String, String> delegateMap;
        private List<EventBinding> eventBindings;
        private final Handler handler;
        private WeakReference<View> rootView;

        public ViewMatcher(View view, Handler handler2, HashMap<String, String> hashMap, String str) {
            AppMethodBeat.i(17486);
            this.rootView = new WeakReference<>(view);
            this.handler = handler2;
            this.delegateMap = hashMap;
            this.activityName = str;
            this.handler.postDelayed(this, 200);
            AppMethodBeat.o(17486);
        }

        public void run() {
            AppMethodBeat.i(17487);
            FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
            if (appSettingsWithoutQuery == null || !appSettingsWithoutQuery.getCodelessEventsEnabled()) {
                AppMethodBeat.o(17487);
                return;
            }
            this.eventBindings = EventBinding.parseArray(appSettingsWithoutQuery.getEventBindings());
            if (this.eventBindings != null) {
                View view = this.rootView.get();
                if (view == null) {
                    AppMethodBeat.o(17487);
                    return;
                }
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.addOnGlobalLayoutListener(this);
                    viewTreeObserver.addOnScrollChangedListener(this);
                }
                startMatch();
            }
            AppMethodBeat.o(17487);
        }

        public void onGlobalLayout() {
            AppMethodBeat.i(17488);
            startMatch();
            AppMethodBeat.o(17488);
        }

        public void onScrollChanged() {
            AppMethodBeat.i(17489);
            startMatch();
            AppMethodBeat.o(17489);
        }

        private void startMatch() {
            AppMethodBeat.i(17490);
            if (!(this.eventBindings == null || this.rootView.get() == null)) {
                for (int i2 = 0; i2 < this.eventBindings.size(); i2++) {
                    findView(this.eventBindings.get(i2), this.rootView.get());
                }
            }
            AppMethodBeat.o(17490);
        }

        public void findView(EventBinding eventBinding, View view) {
            AppMethodBeat.i(17491);
            if (eventBinding == null || view == null) {
                AppMethodBeat.o(17491);
            } else if (TextUtils.isEmpty(eventBinding.getActivityName()) || eventBinding.getActivityName().equals(this.activityName)) {
                List<PathComponent> viewPath = eventBinding.getViewPath();
                if (viewPath.size() > 25) {
                    AppMethodBeat.o(17491);
                    return;
                }
                for (MatchedView matchedView : findViewByPath(eventBinding, view, viewPath, 0, -1, this.activityName)) {
                    attachListener(matchedView, view, eventBinding);
                }
                AppMethodBeat.o(17491);
            } else {
                AppMethodBeat.o(17491);
            }
        }

        public static List<MatchedView> findViewByPath(EventBinding eventBinding, View view, List<PathComponent> list, int i2, int i3, String str) {
            int i4 = 0;
            AppMethodBeat.i(17492);
            String str2 = str + CodelessMatcher.CURRENT_CLASS_NAME + String.valueOf(i3);
            ArrayList arrayList = new ArrayList();
            if (view == null) {
                AppMethodBeat.o(17492);
                return arrayList;
            }
            if (i2 >= list.size()) {
                arrayList.add(new MatchedView(view, str2));
            } else {
                PathComponent pathComponent = list.get(i2);
                if (pathComponent.className.equals(CodelessMatcher.PARENT_CLASS_NAME)) {
                    ViewParent parent = view.getParent();
                    if (parent instanceof ViewGroup) {
                        List<View> findVisibleChildren = findVisibleChildren((ViewGroup) parent);
                        int size = findVisibleChildren.size();
                        while (i4 < size) {
                            arrayList.addAll(findViewByPath(eventBinding, findVisibleChildren.get(i4), list, i2 + 1, i4, str2));
                            i4++;
                        }
                    }
                    AppMethodBeat.o(17492);
                    return arrayList;
                } else if (pathComponent.className.equals(CodelessMatcher.CURRENT_CLASS_NAME)) {
                    arrayList.add(new MatchedView(view, str2));
                    AppMethodBeat.o(17492);
                    return arrayList;
                } else if (!isTheSameView(view, pathComponent, i3)) {
                    AppMethodBeat.o(17492);
                    return arrayList;
                } else if (i2 == list.size() - 1) {
                    arrayList.add(new MatchedView(view, str2));
                }
            }
            if (view instanceof ViewGroup) {
                List<View> findVisibleChildren2 = findVisibleChildren((ViewGroup) view);
                int size2 = findVisibleChildren2.size();
                while (i4 < size2) {
                    arrayList.addAll(findViewByPath(eventBinding, findVisibleChildren2.get(i4), list, i2 + 1, i4, str2));
                    i4++;
                }
            }
            AppMethodBeat.o(17492);
            return arrayList;
        }

        private static boolean isTheSameView(View view, PathComponent pathComponent, int i2) {
            String valueOf;
            String valueOf2;
            AppMethodBeat.i(17493);
            if (pathComponent.index == -1 || i2 == pathComponent.index) {
                if (!view.getClass().getCanonicalName().equals(pathComponent.className)) {
                    if (pathComponent.className.matches(".*android\\..*")) {
                        String[] split = pathComponent.className.split("\\.");
                        if (split.length > 0) {
                            if (!view.getClass().getSimpleName().equals(split[split.length - 1])) {
                                AppMethodBeat.o(17493);
                                return false;
                            }
                        } else {
                            AppMethodBeat.o(17493);
                            return false;
                        }
                    } else {
                        AppMethodBeat.o(17493);
                        return false;
                    }
                }
                if ((pathComponent.matchBitmask & PathComponent.MatchBitmaskType.ID.getValue()) > 0 && pathComponent.id != view.getId()) {
                    AppMethodBeat.o(17493);
                    return false;
                } else if ((pathComponent.matchBitmask & PathComponent.MatchBitmaskType.TEXT.getValue()) <= 0 || pathComponent.text.equals(ViewHierarchy.getTextOfView(view))) {
                    if ((pathComponent.matchBitmask & PathComponent.MatchBitmaskType.DESCRIPTION.getValue()) > 0) {
                        String str = pathComponent.description;
                        if (view.getContentDescription() == null) {
                            valueOf2 = "";
                        } else {
                            valueOf2 = String.valueOf(view.getContentDescription());
                        }
                        if (!str.equals(valueOf2)) {
                            AppMethodBeat.o(17493);
                            return false;
                        }
                    }
                    if ((pathComponent.matchBitmask & PathComponent.MatchBitmaskType.HINT.getValue()) <= 0 || pathComponent.hint.equals(ViewHierarchy.getHintOfView(view))) {
                        if ((pathComponent.matchBitmask & PathComponent.MatchBitmaskType.TAG.getValue()) > 0) {
                            String str2 = pathComponent.tag;
                            if (view.getTag() == null) {
                                valueOf = "";
                            } else {
                                valueOf = String.valueOf(view.getTag());
                            }
                            if (!str2.equals(valueOf)) {
                                AppMethodBeat.o(17493);
                                return false;
                            }
                        }
                        AppMethodBeat.o(17493);
                        return true;
                    }
                    AppMethodBeat.o(17493);
                    return false;
                } else {
                    AppMethodBeat.o(17493);
                    return false;
                }
            } else {
                AppMethodBeat.o(17493);
                return false;
            }
        }

        private static List<View> findVisibleChildren(ViewGroup viewGroup) {
            AppMethodBeat.i(17494);
            ArrayList arrayList = new ArrayList();
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt.getVisibility() == 0) {
                    arrayList.add(childAt);
                }
            }
            AppMethodBeat.o(17494);
            return arrayList;
        }

        private void attachListener(MatchedView matchedView, View view, EventBinding eventBinding) {
            boolean z;
            boolean z2;
            AppMethodBeat.i(17495);
            if (eventBinding == null) {
                AppMethodBeat.o(17495);
                return;
            }
            try {
                View view2 = matchedView.getView();
                if (view2 == null) {
                    AppMethodBeat.o(17495);
                } else if (ViewHierarchy.isRCTButton(view2)) {
                    attachRCTListener(matchedView, view, eventBinding);
                    AppMethodBeat.o(17495);
                } else {
                    String viewMapKey = matchedView.getViewMapKey();
                    View.AccessibilityDelegate existingDelegate = ViewHierarchy.getExistingDelegate(view2);
                    boolean z3 = existingDelegate != null;
                    if (!z3 || !(existingDelegate instanceof CodelessLoggingEventListener.AutoLoggingAccessibilityDelegate)) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (!z || !((CodelessLoggingEventListener.AutoLoggingAccessibilityDelegate) existingDelegate).getSupportCodelessLogging()) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (!this.delegateMap.containsKey(viewMapKey) && (!z3 || !z || !z2)) {
                        view2.setAccessibilityDelegate(CodelessLoggingEventListener.getAccessibilityDelegate(eventBinding, view, view2));
                        this.delegateMap.put(viewMapKey, eventBinding.getEventName());
                    }
                    AppMethodBeat.o(17495);
                }
            } catch (FacebookException e2) {
                String unused = CodelessMatcher.TAG;
                AppMethodBeat.o(17495);
            }
        }

        private void attachRCTListener(MatchedView matchedView, View view, EventBinding eventBinding) {
            boolean z;
            boolean z2;
            AppMethodBeat.i(17496);
            if (eventBinding == null) {
                AppMethodBeat.o(17496);
                return;
            }
            View view2 = matchedView.getView();
            if (view2 == null || !ViewHierarchy.isRCTButton(view2)) {
                AppMethodBeat.o(17496);
                return;
            }
            String viewMapKey = matchedView.getViewMapKey();
            View.OnTouchListener existingOnTouchListener = ViewHierarchy.getExistingOnTouchListener(view2);
            boolean z3 = existingOnTouchListener != null;
            if (!z3 || !(existingOnTouchListener instanceof RCTCodelessLoggingEventListener.AutoLoggingOnTouchListener)) {
                z = false;
            } else {
                z = true;
            }
            if (!z || !((RCTCodelessLoggingEventListener.AutoLoggingOnTouchListener) existingOnTouchListener).getSupportCodelessLogging()) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (!this.delegateMap.containsKey(viewMapKey) && (!z3 || !z || !z2)) {
                view2.setOnTouchListener(RCTCodelessLoggingEventListener.getOnTouchListener(eventBinding, view, view2));
                this.delegateMap.put(viewMapKey, eventBinding.getEventName());
            }
            AppMethodBeat.o(17496);
        }
    }
}
