import pymongo

# Función para buscar juegos por nombre (con palabras clave o aproximaciones)
def buscar_juegos_por_nombre(aproximacion_nombre):
    # Conecta a tu servidor de MongoDB
    client = pymongo.MongoClient('mongodb://user:1234@ac-idgyi4w-shard-00-00.ciwruv5.mongodb.net:27017,ac-idgyi4w-shard-00-01.ciwruv5.mongodb.net:27017,ac-idgyi4w-shard-00-02.ciwruv5.mongodb.net:27017/?replicaSet=atlas-u9kl0f-shard-0&ssl=true&authSource=admin')

    # Selecciona la base de datos y la colección de destino
    db = client['proyecto']
    collection = db['Videojuego']

    # Define el filtro para buscar juegos por nombre
    filtro = {"nombre": {"$regex": f".*{aproximacion_nombre}.*", "$options": "i"}}

    # Realiza la búsqueda con el filtro
    resultados = collection.find(filtro)

    # Itera sobre los resultados e imprime los juegos encontrados
    for juego in resultados:
        print("Nombre:", juego["nombre"])
        print("Plataforma:", juego["plataforma"])
        print("Rating:", juego["rating"])
        print("Género:", juego["genero"])
        print("\n")

# Solicita al usuario que ingrese una aproximación o palabra clave para buscar
aproximacion_nombre = input("Ingresa una aproximación o palabra clave del nombre del juego: ")
buscar_juegos_por_nombre(aproximacion_nombre)
