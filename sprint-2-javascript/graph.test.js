const getNearbyCities = require('./graph.js');

// Describe agrupa pruebas relacionadas
describe('getNearbyCities', () => {

    // --- Pruebas de Funcionalidad Principal (Escenarios Positivos) ---
    test('should return nearby cities for a known destination', () => {
        const nearby = getNearbyCities('Querétaro');
        expect(nearby).toHaveLength(2); // Esperamos que devuelva 2 ciudades
        expect(nearby).toContainEqual({ city: 'Mexico City', distance: 212 });
        expect(nearby).toContainEqual({ city: 'San Miguel de Allende', distance: 65 });
    });

    test('should return an empty array for a city with no connections', () => {
        // Creamos un caso de prueba personalizado
        const customData = {
            'Tulum': { connections: {} }
        };
        const nearby = getNearbyCities('Tulum', customData);
        expect(nearby).toHaveLength(0);
    });

    // --- Pruebas de Casos de Borde (Edge Cases) ---
    test('should return an empty array for a destination that does not exist', () => {
        const nearby = getNearbyCities('Guadalajara');
        expect(nearby).toEqual([]); // Debe ser un array vacío
    });

    // --- Pruebas de Manejo de Errores (Retroalimentación) ---
    test('should throw an error for a null destination', () => {
        // Verificamos que se lanza un error cuando la entrada es inválida
        expect(() => {
            getNearbyCities(null);
        }).toThrow('Destination must be a non-empty string.');
    });

    test('should throw an error for a non-string destination', () => {
        expect(() => {
            getNearbyCities(123);
        }).toThrow('Destination must be a non-empty string.');
    });
});