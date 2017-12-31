# ExpandPopViewDemo
 [ ![Download](https://api.bintray.com/packages/tonight/maven/expandpopview/images/download.svg) ](https://bintray.com/tonight/maven/expandpopview/_latestVersion)

#### 仿美团下拉 一、二级列表 （待续完善）

- ### 使用方法

    1. 引入
     ```
      compile 'com.example.thatnight:expandpopview:1.1.6'
     ```
	  
    2. 布局中
     ```
       <com.example.expandpopview.view.ExpandPopView
          android:id="@+id/elv_main"
          android:layout_width="match_parent"
          android:layout_height="wrap_content"
          />
     ```

    3. 代码中
     ```
      public class MainActivity extends AppCompatActivity {

          private ExpandPopView mExpandPopView;
          private List<KeyValue> mParentList;
          private List<KeyValue> mChildList;
          private List<List<KeyValue>> mParentChild;
          private List<KeyValue> mOneList;

          @Override
          protected void onCreate(Bundle savedInstanceState) {
              super.onCreate(savedInstanceState);
              setContentView(R.layout.activity_main);
              mExpandPopView = findViewById(R.id.elv_main);
              mParentList = new ArrayList<>();
              mParentChild = new ArrayList<>();
              mOneList = new ArrayList<>();

              for (int i = 0; i < 10; i++) {
                  mOneList.add(new KeyValue("一级列表" + i, i + ""));
              }
              mExpandPopView.addItemToExpandTab("一级", mOneList, new OnOneListCallback() {
                  @Override
                  public void returnKeyValue(int pos, KeyValue keyValue) {
                      Toast.makeText(MainActivity.this, keyValue.getKey() + " " + keyValue.getValue(), Toast.LENGTH_SHORT).show();

                  }

              });

              for (int i = 0; i < 10; i++) {
                  mParentList.add(new KeyValue("安卓分类" + i, i + ""));
                  mChildList = new ArrayList<>();
                  for (int j = 0; j < 2; j++) {
                      mChildList.add(new KeyValue(i + " " + j, j + ""));
                  }
                  mParentChild.add(mChildList);
              }
              mExpandPopView.addItemToExpandTab("二级", mParentList, mParentChild, new OnTwoListCallback() {
                  @Override
                  public void returnParentKeyValue(int pos, KeyValue keyValue) {
                      Toast.makeText(MainActivity.this, pos + "  " + keyValue.getKey() + " " + keyValue.getValue(), Toast.LENGTH_SHORT).show();
      //                mChildList = new ArrayList<>();
      //                for (int j = 0; j < 2; j++) {
      //                    mChildList.add(new KeyValue(j + "asd" + j, j + ""));
      //                }
      //                mExpandPopView.refreshItemChildrenData(1, mChildList);
                  }

                  @Override
                  public void returnChildKeyValue(int pos, KeyValue keyValue) {
                      Toast.makeText(MainActivity.this, pos + "  " + keyValue.getKey() + " " + keyValue.getValue(), Toast.LENGTH_SHORT).show();

                  }
              });
          }
      }
     ```

- ### 已实现功能

  - 支持一、二级列表
  - 支持更新列表和子列表

- ### 待完善

  - 列表的下拉箭头
  - 性能和资源的优化
  - 支持扩展（多级列表）

- ### 参考demo
  https://github.com/yihu0817/ExpandPopTabView
