# Chương 6: Đồng bộ hóa

> Họ và tên: Hoàng Hải Đăng
>
> MSSV: 20160982
>
> Mã lớp: 114605
>
> Mã học phần: IT4614

## Câu 1

> Launch this program several times. What do you notice? Explain it!

Kết quả thu được sau 3 lần chạy chương trình

![](https://raw.githubusercontent.com/danghh-1998/distributed_systems/chapter_6/synchronization/images/async_1.png)

![](https://raw.githubusercontent.com/danghh-1998/distributed_systems/chapter_6/synchronization/images/async_2.png)

![](https://raw.githubusercontent.com/danghh-1998/distributed_systems/chapter_6/synchronization/images/async_3.png)

Giải thích:

- Ta thấy lệnh `System.out.println("Start asynchronize " + resource.getRsc());` viết sau khi thực hiện **start ** các thread nhưng các thread này chạy bất đồng bộ nên kết quả sẽ được in ra ngay trong lúc các thread đang chạy, do vậy kết quả in ra nhiều khả năng không đạt 3000.
- Các thread này cùng truy cập đến chung một đối tượng `resource` nên khi in kết quả thường lớn hơn 1000.
- Tiềm ẩn **deadlock** nếu chạy trong thời gian đủ dài hoặc chạy nhiều lần, **deadlock** xảy ra khi nhiều hơn 2 tiến trính cùng truy cập vào object **resource**.

## Câu 2

> Change the code of the general executable program by replacing ThreadedWorkerWithoutSync with ThreadedWorkerWithSync to initiate three instances worker1-3. What is the difference between the output of this program and that of question 1? Explain it!

Kết quả so sánh với câu 1

![](https://raw.githubusercontent.com/danghh-1998/distributed_systems/chapter_6/synchronization/images/sync.png)

Giải thích

- Khi chạy phương thức `run()` của thread 1, do nó được định nghĩa `synchronized` nên nó sẽ lock thread 2 đến khi  nào thread 1 thực hiện xong, do không thể chạy cả 3 thread cùng lúc như câu 1 nên kết quả in ra luôn nhỏ hơn khi chạy ở câu 1.
- Hạn chế `deadlock` do thread sau muốn chạy phải đợi cho thread trước đó chạy xong. Tuy nhiên chạy sẽ mất nhiều thời gian hơn, không tận dụng được ưu điểm của lập trình bất đồng bộ mang lại.

## Câu 3

> Change the code of the general executable program by replacing ThreadedWorkerWithSync with ThreadedWorkerWithLock to initiate three instances worker1-3. What is the difference between the output of this program and the output in question 1? Explain it!

Kết quả so sánh với câu 1 và câu 2

![](https://raw.githubusercontent.com/danghh-1998/distributed_systems/chapter_6/synchronization/images/lock.png)

Giải thích

- Ở cách này ta dùng phương thức `try_lock()`, thay vì lock các thread sau đó, thread yêu cầu truy cập sẽ xem xét object **resource** có đang được sử dụng không, nếu không nó sẽ truy cập, nếu có nó sẽ đợi một khoảng thời gian ở đây là 10 giây hoặc cho đến khi có thể truy cập được object. Cách này có thể tránh được deadlock, hơn nữa có thể tận dụng được ưu điểm của lập trình bất đồng bộ. Do vậy kết quả khi in ra là 3000.

## Câu 5

> Try to increase the value of threads and the value of the constant NUM_TRANS after each execution time until you obtain the different results between Balance and INIT_BALANCE+credits-debits. Explain why do you get this difference.

Kết quả khi thực hiện số thread là 10 và NUM_TRANS = 100

![](https://raw.githubusercontent.com/danghh-1998/distributed_systems/chapter_6/synchronization/images/trans.png)

Giải thích

- Do ở đây các thread cùng dùng chung các biến `credits`, `debits` và `balance` nên ở một thời điểm nào đó sẽ có trường hợp 2 thread cùng truy cập đến các biến này và thay đổi giá trị của nó, dẫn đến kết quả in ra màn hình sai.

## Câu 6

> Try to build and run this program. Launch it repeatedly until you see the difference between Shared and Expect values. Analyze the source code to understand the problem that leads to this difference.

Kết quả khi thực hiện với số thread là 10

![](https://raw.githubusercontent.com/danghh-1998/distributed_systems/chapter_6/synchronization/images/naive.png)

Giải thích

- Ở đây áp dụng kỹ thuật lock các thread cho đến khi thread trước đó chạy xong. Tuy nhiên ở đây gặp phải một vấn đề đó là khi chạy, thread đầu tiên sẽ chạy và lock các thread sau đó, các thread này sẽ liên tục kiểm tra biến `lock` đã về 0 hay chưa. Tại thời điểm thread đầu tiên chạy xong, sẽ có trường hợp nhiều hơn 2 thread cùng truy cập vào biến `lock` để thay đổi thành `lock` thành 1 và lock lẫn nhau. Điều này dẫn đến các thread không chạy theo quy trình `lock -> shared ++ > unlock` mà chia ra thành nhiều đoạn nhỏ chạy đan xen vào nhau. Dẫn đến kết quả cuối cùng không chính xác.

## Câu 7

> Now, you have to modify the code of the file without-lock.c in implementing the mutex lock above (you can name it differently like mutex-lock- banking.c). Try to launch it repeatedly and evaluate the obtained output. What is the improvement after using mutex lock?

Kết quả khi thực hiện với số thread là 10

![](https://raw.githubusercontent.com/danghh-1998/distributed_systems/chapter_6/synchronization/images/mutex.png)

Giải thích

- Điểm khác nhau so với **naive lock** ở trên là nếu thread A lock thì phải do thread A unlock, sau đó thread B mới được sử dụng các biến.

## Câu 8

> compare the run times of the two strategies to prove that Fine Locking is faster and much faster on larger load sets.

Thời gian chạy nếu dùng **Fine locking** nhanh hơn dùng **Mutex lock**

## Câu 9

> Run this program and what do you get as output? Explain what the deadlock is.

Không có output do chương trình không thể kết thúc do **deadlock**

**Deadlock** là hiện tượng tranh chấp tài nguyên giữa hai hay nhiều lệnh trong đó lệnh này giữ tài nguyên mà lệnh kia cần dẫn tới việc không lệnh nào có thể kết thúc để giải phóng tài nguyên. Dẫn đến chương trình không thể kết thúc mà giữ ở  nguyên trạng thái không thực hiện.

Ở đây `fun2` cần thay đổi giá trị của a nhưng `fun1` đã lock dẫn đến phải đợi `fun1` thực hiện xong. Tuy nhiên trong lúc `fun1` chạy lại cần thay đổi giá trị của b nhưng `fun2` đã lock dẫn đến `fun1` phải đợi `fun2`. Đến đây 2 thread đợi nhau dẫn đến chương trình bị treo, không thực hiện tiếp.