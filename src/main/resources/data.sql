-- Insertar roles básicos
INSERT INTO public.roles(id, name)
SELECT 1, 'ROLE_USER'
WHERE NOT EXISTS (SELECT 1 FROM public.roles WHERE id = 1);

INSERT INTO public.roles(id, name)
SELECT 2, 'ROLE_ADMIN'
WHERE NOT EXISTS (SELECT 1 FROM public.roles WHERE id = 2);

-- Insertar proyecto por defecto
INSERT INTO public.projects(project_id, project_name, price)
SELECT 1, 'Default Project', 0.0
WHERE NOT EXISTS (SELECT 1 FROM public.projects WHERE project_id = 1);

-- Insertar cliente admin
INSERT INTO public.clients(client_id, client_name, email, password, project_id)
SELECT 1, 'admin', 'admin@admin.com',
       '$2a$10$VReY3QH7imZ29.gAVgiy3.nPWVAMTE6o5t0YaZ32xB05lohtygByO', 1
WHERE NOT EXISTS (SELECT 1 FROM public.clients WHERE client_id = 1);

-- Asignar rol admin al cliente admin
INSERT INTO public.client_roles(client_id, role_id)
SELECT 1, 2
WHERE NOT EXISTS (
    SELECT 1 FROM public.client_roles
    WHERE client_id = 1 AND role_id = 2
);

-- Insertar usuario de prueba
INSERT INTO public.clients(client_id, client_name, email, password, project_id)
SELECT 2, 'usuario', 'usuario@usuario.com',
       '$2a$10$VReY3QH7imZ29.gAVgiy3.nPWVAMTE6o5t0YaZ32xB05lohtygByO', 1
WHERE NOT EXISTS (SELECT 1 FROM public.clients WHERE client_id = 2);

-- Asignar rol user al usuario de prueba
INSERT INTO public.client_roles(client_id, role_id)
SELECT 2, 1
WHERE NOT EXISTS (
    SELECT 1 FROM public.client_roles
    WHERE client_id = 2 AND role_id = 1
);