public class AATree {
    private AANode root;
    private static AANode nil = new AANode();

    public AATree() {
        root = nil;
    }

    public boolean isEmpty() {
        return root == nil;
    }

    /** Чистка всего дерева **/
    public void clear() {
        root = nil;
    }

    /** Вставка данных **/
    public void insert(int X) {
        root = insert(X, root);
    }
    private AANode insert(int X, AANode T) {
        if (T == nil)
            T = new AANode(X, nil, nil);
        else if ( X < T.element )
            T.left = insert(X, T.left);
        else if ( X > T.element)
            T.right = insert(X, T.right);
        else
            return T;

        T = skew(T);
        T = split(T);
        return T;
    }

    /** Скок **/
    private AANode skew(AANode T) {
        if (T == nil)
            return nil;
        else if (T.left == nil)
            return T;
        else if (T.left.level == T.level) {
            AANode L = T.left;
            T.left = L.right;
            L.right = T;
            return L;
        }
        else
            return T;
    }

    /** Разделение **/
    private AANode split(AANode T) {
        if (T == nil)
            return nil;
        else if (T.right == nil || T.right.right == nil)
            return T;
        else if (T.level == T.right.right.level) {
            AANode R = T.right;
            T.right = R.left;
            R.left = T;

            R.level = R.level + 1;
            return R;
        }
        else
            return T;
    }

    /** Уменьшение **/
    private AANode decreaseLevel(AANode T) {
        int shouldBe = Math.min(T.left.level, T.right.level) + 1;
        if (shouldBe < T.level) {
            T.level = shouldBe;
            if (shouldBe < T.right.level)
                T.right.level = shouldBe;
        }
        return T;
    }

    /** Подсчет количества узлов **/
    public int countNodes() {
        return countNodes(root);
    }
    private int countNodes(AANode r) {
        if (r == nil)
            return 0;
        else {
            int l = 1;
            l += countNodes(r.left);
            l += countNodes(r.right);
            return l;
        }
    }
    /** Поиск элемента **/
    public boolean search(int val) {
        return search(root, val);
    }
    private boolean search(AANode r, int val) {
        boolean found = false;
        while ((r != nil) && !found) {
            int rval = r.element;
            if (val < rval)
                r = r.left;
            else if (val > rval)
                r = r.right;
            else {
                found = true;
                break;
            }
            found = search(r, val);
        }
        return found;
    }

    /** Функция для обхода по порядку **/
    public void inorder() {
        inorder(root);
    }
    private void inorder(AANode r) {
        if (r != nil) {
            inorder(r.left);
            System.out.print(r.element +" ");
            inorder(r.right);
        }
    }
    /** Функция для обхода по пред очереди **/
    public void preorder() {
        preorder(root);
    }
    private void preorder(AANode r) {
        if (r != nil) {
            System.out.print(r.element +" ");
            preorder(r.left);
            preorder(r.right);
        }
    }
    /** Функция для обхода пост очередью **/
    public void postorder() {
        postorder(root);
    }
    private void postorder(AANode r) {
        if (r != nil) {
            postorder(r.left);
            postorder(r.right);
            System.out.print(r.element +" ");
        }
    }
}