# Chương 7: Sao lưu và thống nhất dữ liệu

> Họ và tên: Hoàng Hải Đăng
>
> MSSV: 20160982
>
> Mã lớp: 114605
>
> Mã học phần: IT4614

## Câu 1

> What is the output did you see? Now, try to add another entry to the table pet in using SQL queries.

- Output sau khi thực hiện truy vấn `SELECT * FROM pet`

![](https://raw.githubusercontent.com/danghh-1998/distributed_systems/chapter_7/consistency_and_replication/images/pet-database.png)

- Thêm dữ liệu vào database

![](https://raw.githubusercontent.com/danghh-1998/distributed_systems/chapter_7/consistency_and_replication/images/insert.png)

## Câu 2

> What is the name of the log file and the position?

- Tên file log: __mysql-bin.000003__.

- Position: 1431

  ![](https://raw.githubusercontent.com/danghh-1998/distributed_systems/chapter_7/consistency_and_replication/images/master-status.png)

## Câu 3

> Have you received this file in Slave machine? What is the path of this received file in the Slave machine?

- Nhận được file __petdatabase.sql__ ở thư mục `$HOME` ở Slave machine.

![](https://raw.githubusercontent.com/danghh-1998/distributed_systems/chapter_7/consistency_and_replication/images/list.png)

## Câu 4

> What is the status information you received? How do you know the configuration is OK?

- Kết quả nhận được khi chạy lệnh `show slave status\G`

![](https://raw.githubusercontent.com/danghh-1998/distributed_systems/chapter_7/consistency_and_replication/images/slave-status.png)

- Kết quả thành công vì `Last_IO_Error` và `Last_IO_Error_Timestamp` không thông báo lỗi.

## Câu 5

> In the Slave machine, verify if the new inserted data has been replicated from Master to Slave. Which command did you use?

- Kết quả thu được ở master và slave machine là như nhau.
- Ở master machine

![](https://raw.githubusercontent.com/danghh-1998/distributed_systems/chapter_7/consistency_and_replication/images/master-verify.png)

- Ở slave machine

![](https://raw.githubusercontent.com/danghh-1998/distributed_systems/chapter_7/consistency_and_replication/images/slave-verify.png)