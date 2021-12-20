//单链表源文件
#include "LinkList.h"
#include "stdio.h"
#include "stdlib.h"

//创建单链表
LinkList *list_init(){
  //创建一个单链表结构
  LinkList *temp = (LinkList *)malloc(sizeof(LinkList));//动态分配一段内存用来创建一个新的链表

  if (temp == NULL) {
    printf("error1.1:单链表创建失败\n");
    return NULL;
  }
  //初始化链表头节点和尾节点，防止出现野指针
  temp->head = NULL;
  temp->end = NULL;
  //初始化链表长度为0
  temp->length = 0;

  return temp;
}

//创建节点
Node *node_init(Type val){ //val = 需要存储的数据
  Node *temp = (Node *)malloc(sizeof(Node));

  if (temp == NULL) {
    printf("error2.1:单链表节点创建失败\n");
    return NULL;
  }

  temp->data = val; //将数据放入数据域
  temp->next = NULL; //初始化节点指针域

  return temp;
}

//数据插入_尾插法
void list_insert_end(LinkList *list, Type data){
  if (list == NULL) {
    printf("error3.1.1:链表不存在\n");
    return;
  }

  if (list->head == NULL && list->end == NULL) { //如果链表为空(第一个节点的创建)
    list->head = list->end = node_init(data); //将头尾节点指向当前节点
    list->length++; //链表长度+1
  } else { //不是第一个节点的创建
    list->end = list->end->next = node_init(data);
    list->length++;
  }
}

//数据插入_指定位置
void list_insert(LinkList *list, int index, Type data){
  if (list == NULL) {
    printf("error3.2.1:链表不存在\n");
    return;
  }

  if (index <= 0 || index > list->length + 1) {
    printf("error3.2.2:插入位置错误\n");
    return;
  }

  if (index == 1) { //插入位置在头节点之前
    Node *new = (Node *)malloc(sizeof(Node));//创建一个新节点存储需要插入的数据
    new->next = list->head; //将当前节点的next指向原头节点
    list->head = new; //将头节点设置为当前节点
    return;
  }

  if (index == (list->length+1)) { //插入位置在尾节点之后
    list_insert_end(list, data); //调用尾插法函数
    //list->end = list->end->next = node_init(data);//参考list_insert_end的尾插法
    //list->length++; //链表长度+1
    return;
  }

  //中间节点的插入
  Node *temp = list->head; //定义一个临时指针用来指向插入节点的前一个节点
  for (int i = 1; i < (index - 1); i++) { //循环遍历找到前一个节点
    temp = temp->next;
  }


  Node *new = (Node *)malloc(sizeof(Node)); //创建一个新节点存储需要插入的数据
  new->data = data; //将数据放入新节点数据域
  new->next = temp->next; //将当前节点的next指向前一个节点的后两个节点(下一个节点)
  temp->next = new; //将前一个节点的next指向当前节点
  /*注：一定要先连接后面再连接前面*/

  list->length++; //链表长度+1
}

//输出单链表
void list_printout(LinkList *list){
  if (list == NULL || list->head == NULL) {
    printf("error4.1:链表为空，输出失败\n");
  } else {
    for (Node *temp = list->head; temp != NULL; temp = temp->next) {
      printf(TYPE_P, temp->data);
    }
    puts("NULL\n");
    putchar('\n');
  }
}

//删除单链表节点
Type list_delate(LinkList *list, int index){
  if (list == NULL) {
    printf("error5.1:链表不存在\n");
    exit(0);
  }

  if (list->head == NULL) {
    printf("error5.2链表数据域为空，删除数据失败");
    exit(0);
  }

  if (index <= 0 || index > list->length + 1) {
    printf("error5.3:删除位置错误\n");
    exit(0);
  }

  if (index == 1) { //删除头部节点
    Node *temp = list->head; //记录被删除的头节点

    list->head = list->head->next; //将头节点的下一个节点设置成新的头节点

    Type val = temp->data; //存储头节点数据

    free(temp); //删除头节点

    list->length--; //链表长度-1

    return val; //返回删除的数据
  }

  if (index == list->length) { //删除尾部节点
    Node *temp = list->head;
    for (int i = 1; i < index - 1; i++) { //找到尾节点的前一个节点
      temp = temp->next;
    }

    Type val = temp->next->data; //存储头节点数据

    free(list->end); //删除头节点

    list->end = temp; //将倒数第二个节点设置成新的尾节点

    temp->next = NULL; //将新的尾节点的next指向空

    list->length--; //链表长度-1

    return val; //返回删除的数据
  }

  Node *temp1 = list->head;
  for (int i = 1; i < (index - 1); i++) {//将temp1指向被删除位置的前一个节点
    temp1 = temp1->next;
  }

  Node *temp2 = temp1->next; //记录被删除节点的位置

  Type val = temp1->next->data; //存储被删除的数据

  temp1->next = temp2->next; //将被删除位置的上一个节点的next指向下一个节点

  free(temp2);

  list->length--; //链表长度-1

  return val; //返回被删除的数据
}

//链表的冒泡排序
Node listBubbleSort(Node *listhead, LinkList *list){
  Node *p = listhead;
  Node *q = listhead->next;
  for (int i = 0; i < list->length-1; i++) { //外层循环每次可以确定一个数的位置
      while ((p != NULL) && (q != NULL)) {
        if (p->data > q->data) {
          int temp;
          temp = p->data;
          p->data = q->data;
          q->data = temp;
        }
        p = p->next;
        q = q->next;
      }
      p = listhead;
      q = listhead->next;
  }
  Node *head = listhead;
  return *head;
}

//查找单链表节点的数据并返回位置
//查找数据并返回位置
void list_lookup_data(LinkList *list, Type data){
  if (list == NULL || list->head == NULL) {
    if (list == NULL) {
      printf("error6.1.1:链表不存在,查找数据失败\n");
      return;
    }

    if (list->head == NULL) {
      printf("error6.1.2:链表数据域为空,查找数据失败");
      return;
    }
  }

  int loc = 0; //用来记录位置
  int a = 0;//如果有这个数据就+1，没有就为0
  for (Node *temp = list->head; temp != NULL; temp = temp->next) {
    loc++; //每次查找位置向后加一
    if (temp->data == data) {
      a++;
      printf("查找数据在链表的第%d个\n", loc);
    }
  }
  if (!a) {
    printf("链表中没有该数据\n");
  }
}



//查找位置并返回数据
Type list_lookup_location(LinkList *list, int index) {
  if (list == NULL || list->head == NULL) {
    if (list == NULL) {
      printf("error6.2.1:链表不存在,查找数据失败\n");
      exit(0);
    }

    if (list->head == NULL) {
      printf("error6.2.2:链表数据域为空,查找数据失败");
      exit(0);
    }
  }

  if (index <= 0 || index > list->length + 1) {
    printf("error6.3:查找位置错误\n");
    exit(0);
  }

  int data = 0;//用于存储查找到的数据

  Node *temp = list->head;
  for (int i = 1; i < (index - 1); i++) {//将temp指向查找位置的前一个节点
    temp = temp->next;
  }

  data = temp->next->data; //将当前节点的data存储入data变量中

  return data; //返回查找到的数据
}

//销毁单链表
void list_delate_all(LinkList *list){
  if (list == NULL) {
    printf("error7.1:链表不存在,销毁失败\n");
    return;
  }

  if (list->head == NULL) {
    printf("error7.2:链表为空,销毁失败");
    return;
  }

  for (Node *temp1 = list->head; temp1 != NULL;) {
    free(list->head); //释放头节点
    temp1 = temp1->next; //将临时节点指向下一个节点
    temp1 = list->head; //将临时节点设置为头节点
  }

  free(list); //释放链表
}
