# favorite-players

![favplayer](https://github.com/2Kelvin/favorite-players/assets/85868026/5872bad0-03d3-4e45-8195-bfed7ecf48c6)

## Future Me Notes

- make a rounded corners in Buttons and Cards using the property
    ```kotlin
    shape = RoundedCornerShape(10.dp)
    ```
- make rounded corners in an image using
    ```kotlin
    modifier = modifier.clip(shape = RoundedCornerShape(10.dp))
    ```
- here's how to make custom reusable objects
  ```kotlin
    data class Player(
        val imageId: Int,
        val name: String,
        val jerseyNumber: Int,
        val position: String,
        val team: String,
    )
  ```
- add more elevation & shadow to an ElevatedCard using
  ```kotlin
  elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
  ```