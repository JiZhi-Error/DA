package android.support.constraint.solver.widgets;

import android.support.constraint.solver.Cache;
import java.util.ArrayList;

public class WidgetContainer extends ConstraintWidget {
    protected ArrayList<ConstraintWidget> mChildren = new ArrayList<>();

    public WidgetContainer() {
    }

    public WidgetContainer(int i2, int i3, int i4, int i5) {
        super(i2, i3, i4, i5);
    }

    public WidgetContainer(int i2, int i3) {
        super(i2, i3);
    }

    @Override // android.support.constraint.solver.widgets.ConstraintWidget
    public void reset() {
        this.mChildren.clear();
        super.reset();
    }

    public void add(ConstraintWidget constraintWidget) {
        this.mChildren.add(constraintWidget);
        if (constraintWidget.getParent() != null) {
            ((WidgetContainer) constraintWidget.getParent()).remove(constraintWidget);
        }
        constraintWidget.setParent(this);
    }

    public void add(ConstraintWidget... constraintWidgetArr) {
        for (ConstraintWidget constraintWidget : constraintWidgetArr) {
            add(constraintWidget);
        }
    }

    public void remove(ConstraintWidget constraintWidget) {
        this.mChildren.remove(constraintWidget);
        constraintWidget.setParent(null);
    }

    public ArrayList<ConstraintWidget> getChildren() {
        return this.mChildren;
    }

    public ConstraintWidgetContainer getRootConstraintContainer() {
        ConstraintWidgetContainer constraintWidgetContainer;
        ConstraintWidget parent = getParent();
        if (this instanceof ConstraintWidgetContainer) {
            constraintWidgetContainer = (ConstraintWidgetContainer) this;
        } else {
            constraintWidgetContainer = null;
        }
        while (parent != null) {
            ConstraintWidget parent2 = parent.getParent();
            if (parent instanceof ConstraintWidgetContainer) {
                constraintWidgetContainer = (ConstraintWidgetContainer) parent;
                parent = parent2;
            } else {
                parent = parent2;
            }
        }
        return constraintWidgetContainer;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.support.constraint.solver.widgets.ConstraintWidget] */
    /* JADX WARN: Type inference failed for: r0v9 */
    public ConstraintWidget findWidget(float f2, float f3) {
        WidgetContainer widgetContainer = null;
        int drawX = getDrawX();
        int drawY = getDrawY();
        int width = getWidth() + drawX;
        int height = getHeight() + drawY;
        if (f2 >= ((float) drawX) && f2 <= ((float) width) && f3 >= ((float) drawY) && f3 <= ((float) height)) {
            widgetContainer = this;
        }
        int size = this.mChildren.size();
        WidgetContainer widgetContainer2 = widgetContainer;
        for (int i2 = 0; i2 < size; i2++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i2);
            if (constraintWidget instanceof WidgetContainer) {
                ConstraintWidget findWidget = ((WidgetContainer) constraintWidget).findWidget(f2, f3);
                if (findWidget == null) {
                    findWidget = widgetContainer2;
                }
                widgetContainer2 = findWidget;
            } else {
                int drawX2 = constraintWidget.getDrawX();
                int drawY2 = constraintWidget.getDrawY();
                int width2 = constraintWidget.getWidth() + drawX2;
                int height2 = constraintWidget.getHeight() + drawY2;
                if (f2 >= ((float) drawX2) && f2 <= ((float) width2) && f3 >= ((float) drawY2) && f3 <= ((float) height2)) {
                    widgetContainer2 = constraintWidget;
                }
            }
        }
        return widgetContainer2;
    }

    public ArrayList<ConstraintWidget> findWidgets(int i2, int i3, int i4, int i5) {
        ArrayList<ConstraintWidget> arrayList = new ArrayList<>();
        Rectangle rectangle = new Rectangle();
        rectangle.setBounds(i2, i3, i4, i5);
        int size = this.mChildren.size();
        for (int i6 = 0; i6 < size; i6++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i6);
            Rectangle rectangle2 = new Rectangle();
            rectangle2.setBounds(constraintWidget.getDrawX(), constraintWidget.getDrawY(), constraintWidget.getWidth(), constraintWidget.getHeight());
            if (rectangle.intersects(rectangle2)) {
                arrayList.add(constraintWidget);
            }
        }
        return arrayList;
    }

    public static Rectangle getBounds(ArrayList<ConstraintWidget> arrayList) {
        int i2;
        Rectangle rectangle = new Rectangle();
        if (arrayList.size() == 0) {
            return rectangle;
        }
        int size = arrayList.size();
        int i3 = 0;
        int i4 = 0;
        int i5 = Integer.MAX_VALUE;
        int i6 = 0;
        int i7 = Integer.MAX_VALUE;
        while (i3 < size) {
            ConstraintWidget constraintWidget = arrayList.get(i3);
            if (constraintWidget.getX() < i7) {
                i7 = constraintWidget.getX();
            }
            if (constraintWidget.getY() < i5) {
                i5 = constraintWidget.getY();
            }
            if (constraintWidget.getRight() > i6) {
                i6 = constraintWidget.getRight();
            }
            if (constraintWidget.getBottom() > i4) {
                i2 = constraintWidget.getBottom();
            } else {
                i2 = i4;
            }
            i3++;
            i4 = i2;
        }
        rectangle.setBounds(i7, i5, i6 - i7, i4 - i5);
        return rectangle;
    }

    @Override // android.support.constraint.solver.widgets.ConstraintWidget
    public void setOffset(int i2, int i3) {
        super.setOffset(i2, i3);
        int size = this.mChildren.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.mChildren.get(i4).setOffset(getRootX(), getRootY());
        }
    }

    @Override // android.support.constraint.solver.widgets.ConstraintWidget
    public void updateDrawPosition() {
        super.updateDrawPosition();
        if (this.mChildren != null) {
            int size = this.mChildren.size();
            for (int i2 = 0; i2 < size; i2++) {
                ConstraintWidget constraintWidget = this.mChildren.get(i2);
                constraintWidget.setOffset(getDrawX(), getDrawY());
                if (!(constraintWidget instanceof ConstraintWidgetContainer)) {
                    constraintWidget.updateDrawPosition();
                }
            }
        }
    }

    public void layout() {
        updateDrawPosition();
        if (this.mChildren != null) {
            int size = this.mChildren.size();
            for (int i2 = 0; i2 < size; i2++) {
                ConstraintWidget constraintWidget = this.mChildren.get(i2);
                if (constraintWidget instanceof WidgetContainer) {
                    ((WidgetContainer) constraintWidget).layout();
                }
            }
        }
    }

    @Override // android.support.constraint.solver.widgets.ConstraintWidget
    public void resetSolverVariables(Cache cache) {
        super.resetSolverVariables(cache);
        int size = this.mChildren.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mChildren.get(i2).resetSolverVariables(cache);
        }
    }

    public void removeAllChildren() {
        this.mChildren.clear();
    }
}
