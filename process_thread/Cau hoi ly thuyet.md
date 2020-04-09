# Chương 3: Tiến trình và luồng

> Họ và tên: Hoàng Hải Đăng
>
> MSSV: 20160982
>
> Mã lớp: 114605
>
> Mã học phần: IT4614

## Câu 1

> Có cần thiết phải giới hạn số lượng các luồng trong một tiến trình server?

- Cần phải giới hạn số thread chạy trong một process vì tài nguyên của server là giới hạn và càng chạy nhiều thread thì càng tốn bộ nhớ, ngoài ra số lượng thread cũng được giới hạn bởi hệ điều hành, ở linux là 32768 thread. Giả sử server là một web server, một request từ người dùng tạo ra một thread để xử lý yêu cầu của người dùng, nếu không giới hạn số thread, server sẽ sử dụng hết tài nguyên (CPU, RAM) trước khi có thể giải phóng bộ nhớ và tạo thêm thread.



## Câu 2

> Có nên chỉ gắn một luồng đơn duy nhất với một tiến trình nhẹ?

- Không nên chỉ gắn một luồng đơn duy nhất với một tiến trình nhẹ.

## Câu 3

> Có nên chỉ có một tiến trình nhẹ đơn gắn với 1 tiến trình?

- Không nên chỉ có một tiến trình nhẹ đơn gắn với một tiến trình. Một tiến trình có thể có nhiều tiến trình nhẹ.

## Câu 4

> Bài toán này yêu cầu bạn so sánh thời gian đọc một tệp (file) của một máy chủ tập tin (file server) đơn luồng và một máy chủ đa luồng. Phải mất tổng cộng 15 ms để nhận 1 yêu cầu (request) và thực hiện quá trình xử lý,  giả định rằng các dữ liệu cần thiết nằm ở bộ nhớ đệm trong bộ nhớ chính. Nếu cần thiết phải thực hiện một thao tác truy cập ổ đĩa thì cần thêm 75 ms, biết rằng việc phải thực hiện thao tác này có xắc suất là 1/3. Hỏimáy chủ có thể nhận bao nhiêu yêu cầu/giây trong 2 trường hợp: máy chủ là đơn luồng và máy chủ là đa luồng (ngoài luồng nhận và xử lý request, sẽ có thêm 1 luồng để truy cập ổ đĩa nếu cần thiết)? Giải thích.

- Đối với máy chủ đơn luồng:

- Thời gian xử lý một yêu cầu trung bình là: 
  $$
  15 * 2/3 + 75 * 1/3 = 40(ms)
  $$

- Số request được xử lý trong một giây:

  
  $$
  1000 / 40 = 25 (request/s)
  $$

- Đối với máy chủ đa luồng, số request được xử lý trong một giây:
  $$
  1000 / 15= 67 (request/s)
  $$



## Câu 5

> Hệ thống X chỉ định máy của user chứa server, trong khi các ứng dụng lại được coi như client. Điều đó có vô lý không? Giải thích

- Không vô lý, ví dụ như hệ CSDL mysql gồm 2 phần mysql-server nằm trên máy người dùng, các ứng dụng muốn giao tiếp với mysql-server đều thông qua mysql-client.

## Câu 6

> Giao thức thiết kế cho hệ thống X gặp phải vấn đề về tính mở rộng. Chỉ ra các giải pháp để giải quyết vấn đề đó?

- Ta có thể cải thiện bằng cách cải thiện giao thức protocol hoặc nén thông điệp.

## Câu 7

> Với việc xây dựng một server đồng thời, hãy so sánh việc server này tạo một luồng mới và tạo một tiến trình mới khi nhận được yêu cầu từ phía client.  

- Tạo một tiến trình mới sẽ tốn tài nguyên hơn tạo một luồng xử lý mới. Tuy nhiên tạo một tiến trình mới sẽ đơn giản hơn tạo một luồng xử lý mới.

## Câu 8

> Nếu bây giờ một webserver tổ chức lưu lại thông tin về địa chỉ IP của client và trang web client đó vừa truy  cập. Khi có 1 client kết nối với server đó, server sẽ tra xem trong bảng thông tin, nếu tìm thấy thì sẽ gửi  nội dung trang web đó cho client. Server này là có trạng thái (stateful) hay không trạng thái (stateless)?

- Server này ở trạng thái stateless.

## Câu 9

> So sánh docker và virtual machines.

1. Giống nhau
- Cả hai đều là các công nghệ ảo hóa để giả lập môi trường thường dùng trong phát triên dự án và thống nhất môi trường phát triển giữa các thành viên trong nhóm phát triển dự án.
2. Khác nhau

|                       Virtual Machines                       |                    Docker                     |
| :----------------------------------------------------------: | :-------------------------------------------: |
|               Ảo hóa về phần cứng (Hypervisor)               |      Ảo hóa về phần mềm (Docker engine)       |
| Cần một phần mềm giám sát máy ảo cài đặt trên một hệ điều hành |       Giao tiếp với kernel của hệ thống       |
|                     Cần nhiều tài nguyên                     |             Cần ít tài nguyên hơn             |
|              Thời gian start máy ảo lâu (phút)               | Thời gian start docker container nhanh (giây) |
|                       Deploy phức tạp                        |                Deploy đơn giản                |
|                      Xử lý yêu cầu chậm                      |              Xử lý yêu cầu nhanh              |
|            Độ bảo mật phụ thuộc vào hệ điều hành             |        Độ bảo mật phụ thuộc vào Docker        |

