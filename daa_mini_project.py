# Bubble Sort Rumble

import pygame

# Initialize Pygame
pygame.init()

# Define constants
WIDTH = 800
HEIGHT = 600
WHITE = (255, 255, 255)
BLACK = (0, 0, 0)
BLUE = (0, 0, 255)
DELAY = 500  # Delay in milliseconds for slow representation

# Initialize screen
screen = pygame.display.set_mode((WIDTH, HEIGHT))
pygame.display.set_caption("Bubble sort rumble")

# Get array input from the user
try:
    array = list(map(int, input("Enter a list of integers (e.g., 5 3 8 6 2): ").split()))
    list_size = len(array)

    def draw_array(arr, color_pos=None):
        screen.fill(WHITE)
        bar_width = WIDTH // list_size
        max_height = max(arr)  # Scale heights to fit the screen
        for i in range(len(arr)):
            color = BLUE if color_pos and i in color_pos else BLACK
            # Scale the bar height to fit within the window
            scaled_height = (arr[i] / max_height) * (HEIGHT - 20)
            pygame.draw.rect(screen, color, [i * bar_width, HEIGHT - scaled_height, bar_width, scaled_height])
        pygame.display.flip()

    # Bubble Sort implementation
    def bubble_sort(arr):
        n = len(arr)
        for i in range(n):
            for j in range(0, n - i - 1):
                if arr[j] > arr[j + 1]:
                    arr[j], arr[j + 1] = arr[j + 1], arr[j]
                    draw_array(arr, [j, j + 1])
                    pygame.time.delay(DELAY)  # Slow representation delay
                for event in pygame.event.get():
                    if event.type == pygame.QUIT:
                        pygame.quit()
                        return

    # Main loop
    running = True
    sorted = False

    while running:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                running = False

        if not sorted:
            bubble_sort(array)
            sorted = True

        pygame.display.flip()

except ValueError:
    print("Invalid input! Please enter a list of integers.")
    pygame.quit()
