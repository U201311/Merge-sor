import static java.lang.Character.MAX_VALUE;

    /**
     * 对数组中的一部分进行插入排序（插入排序的基本思想上优化）
     * 分治算法思想（根据算法导论第三版p17-p20）：
     *   归并排序思想
     * （1）分解：分解待排序的n个元素的序列各具有n/2个元素的两个子序列；
     * （2）解决：使用归并排序递归地排序两个子序列；
     * （3）合并：合并两个已排序的子序列以产生已排序的答案。
     */
    public class MergeSortDemo {
        public static void main(String[] args) {

            /*为了减少输入，直接设定待排序的数组*/
            int [] list={5,2,4,6,1,56,10,8,44,64,3,5,90,24,34};

            /*选择数组中待排序的区域,可以修改*/
            Merge_Sort(list,2,7);

            /*获取排序后的数组*/
            getList(list);


        }
        /**分解过程，并将合并函数Merge作为子程序，此函数中实现了递归,以（2,7）为例，分解后的形式如下
         *       4  6  1   56  10  8
         *         *          *
         *        *              *
         *     4 6 1          56 10 8
         *     *  *             *   *
         *    *     *         *       *
         *    4 6    1       56 10     8
         *    * *     *       *  *      *
         *  *    *      *    *     *     *
         *  4      6     1   56     10    8
         */

        public static void Merge_Sort(int[] list,int p,int r){
            if(p<r) {
                int q = (p + r) /2;
                Merge_Sort(list, p, q);
                Merge_Sort(list, q + 1, r);
                Merge(list, p, q, r);
            }
        }

        /**
         合并排序过程
         *       1  4  6   8  10  56
         *         *          *
         *        *              *
         *     1 4 6          8 10 56
         *     *  *             *   *
         *    *     *         *       *
         *    4 6    1       10 56     8
         *    * *     *       *  *      *
         *  *    *      *    *     *     *
         *  4      6     1   56     10    8
         */
        public static int[] Merge(int[] list,int p,int q,int r){
            int n1=q-p+1+1;
            int n2=r-q+1;
            int[] list1=new int[n1];
            int[] list2=new int[n2];
            list1[n1-1]=MAX_VALUE;
            list2[n2-1]=MAX_VALUE;
            for(int i=0;i<n1-1;i++)
            {
                list1[i]=list[p+i];
            }
            for(int j=0;j<n2-1;j++)
            {
                list2[j]=list[q+j+1];
            }
            int i=0,j=0;
            for(int k=p;k<=r&&i<n1&&j<n2;k++)
            {
                if(list1[i]<=list2[j])
                {
                    list[k]=list1[i];
                    i=i+1;
                }
                else{
                    list[k]=list2[j];
                    j=j+1;
                }
            }
            return list;
        }

        public static void getList(int[] list){

            for(int i=0;i<list.length;i++)
            {
                System.out.print(list[i]+"----");
            }
            System.out.print("\n");
        }

        /*插入排序函数*/
        public static int[] getInsertionSort(int[] list){
            for(int j=1;j<list.length;j++)
            {
                int key=list[j];
                int i=j-1;
                while(i>=0 && list[i]>key){
                    list[i+1]=list[i];
                    i=i-1;
                    list[i+1]=key;
                }
            }
            return list;
        }
    }


