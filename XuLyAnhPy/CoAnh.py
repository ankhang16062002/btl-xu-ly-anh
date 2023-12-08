import cv2
import matplotlib.pyplot as plt
import numpy as np

def apply_dilation(input_path):
    # Đọc ảnh từ đường dẫn
    image = cv2.imread(input_path, cv2.IMREAD_GRAYSCALE)

    # Tạo kernel cho phép toán dilation
    kernel = np.ones((5, 5), np.uint8)

    # Áp dụng phép toán dilation
    dilated_image = cv2.dilate(image, kernel, iterations=1)

    # Hiển thị ảnh gốc và ảnh sau khi áp dụng dilation
    plt.figure(figsize=(10, 5))

    plt.subplot(1, 2, 1)
    plt.imshow(image, cmap='gray')
    plt.title('Original Image')

    plt.subplot(1, 2, 2)
    plt.imshow(dilated_image, cmap='gray')
    plt.title('Dilated Image')

    plt.show()

if __name__ == "__main__":
    input_image_path = 'images/hoa.jpg'
    apply_dilation(input_image_path)
