-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 17-Nov-2019 às 06:54
-- Versão do servidor: 10.3.16-MariaDB
-- versão do PHP: 7.1.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `projetoageis`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `area`
--

CREATE TABLE `area` (
  `id_area` int(11) NOT NULL,
  `nome` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `area`
--

INSERT INTO `area` (`id_area`, `nome`) VALUES
(1, 'Cabeça'),
(2, 'Tronco'),
(3, 'Braço-Esquerdo'),
(4, 'Braço-Direito'),
(5, 'Perna-Esquerda'),
(6, 'Perna-Direita'),
(7, 'Corpo todo');

-- --------------------------------------------------------

--
-- Estrutura da tabela `clinica`
--

CREATE TABLE `clinica` (
  `id_clinica` int(11) NOT NULL,
  `email` varchar(200) DEFAULT NULL,
  `nome` varchar(200) DEFAULT NULL,
  `senha` varchar(200) DEFAULT NULL,
  `telefone` varchar(200) DEFAULT NULL,
  `usuario` varchar(200) DEFAULT NULL,
  `endereco` varchar(200) DEFAULT NULL,
  `especialidade` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `clinica`
--

INSERT INTO `clinica` (`id_clinica`, `email`, `nome`, `senha`, `telefone`, `usuario`, `endereco`, `especialidade`) VALUES
(1, 'https://www.telelistas.net/locais/pe/recife/clinicas+medicas/bu-3500266/clinica+dr+gi\r\nldo+ferreira+lima#contato', 'Clínica Dr Gildo Ferreira Lima', '123', '(81) 3222-2794,\r\n(81) 99966-0908', 'clinicadrgildoferreiralima', 'Rua do Riachuelo, 772 - Boa Vista -\r\nRecife - PE', NULL),
(2, 'https://www.telelistas.net/locais/pe/recife/clinicas+medicas/bu-1526872/uniclinica#c\r\nontato', 'Uniclínica', '123', '(81) 3525-5805, (81) 99834-0335', 'uniclinica', 'Rua\r\nLeandro Barreto, 1384 - Jardim São Paulo - Recife - PE', NULL),
(3, 'https://www.telelistas.net/locais/pe/recife/clinicas+medicas/bu-19147701/clinica+de+\r\nginecologia+dr+helio+costa+em+gracas#contato', 'Clínica de Ginecologia Dr Hélio\r\nCosta em Graças', '123', '(81) 3241-5946', 'drheliocosta', 'Rua Conselheiro Portela,\r\n632 - Graças - Recife - PE, Prox A João de Barros', NULL),
(4, 'https://www.guiamais.com.br/recife-pe/clinicas-medicos-e-terapias/otorrinolaringolog\r\nistas-ouvidos-nariz-e-garganta/12718710-2/iop-instituto-de-otorrino-de-pernambuco#\r\nmaisFone', 'IOP - INSTITUTO DE OTORRINO DE PERNAMBUCO', '123', '(81)\r\n3445-5289, (81) 3227-1618, (81) 3227-5820', 'iop', 'R J A da Silveira, 116 -\r\nMadalena - Recife, PE - CEP: 50610-030', NULL),
(5, 'https://www.guiamais.com.br/recife-pe/clinicas-medicos-e-terapias/otorrinolaringolog\r\nistas-ouvidos-nariz-e-garganta/12376062-2/roberto-lucas-de-oliveira', 'ROBERTO\r\nLUCAS DE OLIVEIRA', '123', '(81) 3467-4400', 'robertolucas', 'Av Engenheiro\r\nDomingos Ferreira, 4371 - an-6 sl-605 - - Boa Viagem - Recife, PE - CEP:\r\n51021-040', NULL),
(6, 'https://www.guiamais.com.br/recife-pe/clinicas-medicos-e-terapias/clinicas-de-derm\r\natologia/16474744-1/clinica-de-dermatologia-real-derma', 'CLÍNICA DE\r\nDERMATOLOGIA REAL DERMA', '123', '(81) 3416-1687', 'realderma', 'Av\r\nGovernador Agamenon Magalhães, 163 - Santo Amaro - Recife, PE - CEP:\r\n50110-000', NULL),
(7, 'https://www.guiamais.com.br/recife-pe/clinicas-medicos-e-terapias/clinicas-de-olhos/\r\n1963047-10/ior-instituto-de-olhos-do-recife', 'IOR - INSTITUTO DE OLHOS DO\r\nRECIFE', '123', '(81) 2122-5000, (81) 3213-0725, (81) 3221-0135', 'ior', 'R Doutor\r\nVicente Meira, 137 - Espinheiro - Recife, PE - CEP: 52020-130', NULL),
(8, 'https://www.guiamais.com.br/recife-pe/clinicas-medicos-e-terapias/clinicas-de-olhos/\r\n2162535356-5487128/clinica-de-olhos-romulo-belfort', 'CLÍNICA DE OLHOS\r\nRÔMULO BELFORT', '123', '(81) 3326-0696', 'romulobelfort', 'Av Fernando Simões\r\nBarbosa, 22 - 814 - - Boa Viagem - Recife, PE - CEP: 51020-904', NULL),
(9, 'https://www.guiamais.com.br/recife-pe/clinicas-medicos-e-terapias/gastroenterologis\r\nta/14463540-2/ricad-real-instituto-do-aparelho-digestivo', 'RICAD - REAL\r\nINSTITUTO DO APARELHO DIGESTIVO', '123', '(81) 3134-2914, (81) 3416-7749,\r\n(81) 3416-7750', 'ricad', 'Av Portugal, 4760 - Paissandu - Recife, PE - CEP:\r\n52010-010', NULL),
(10, 'https://www.guiamais.com.br/recife-pe/clinicas-medicos-e-terapias/psiquiatras/2161\r\n365902-6187916/dreduardo-silva-santos', 'DR. EDUARDO SILVA SANTOS', '123', '(81) 9908-0525, (81) 3423-7424', 'dreduardosilvasantos', 'Av República do Líbano,\r\n251 - Emp Rio Mar Trade Sala 2715 - - Pina - Recife, PE - CEP: 51110-160', NULL),
(11, 'https://www.guiamais.com.br/recife-pe/clinicas-medicos-e-terapias/endocrinologistas\r\n-e-metabologistas/16091201-1/consultorio-dra-silvia-maranhao', 'CONSULTÓRIO\r\nDRA SÍLVIA MARANHÃO', '123', '(81) 3462-5573, (81) 3461-9937', 'silviamaranhao', 'R Tenente Domingos de Brito, 281 - Boa Viagem - Recife, PE - CEP: 51021-100', NULL),
(12, 'https://www.guiamais.com.br/recife-pe/clinicas-medicos-e-terapias/alergologistas-e-i\r\nmunologistas/8641766-2/clinica-de-alergia-e-asma-marco-aurelio-ramalho-bezerra', 'CLÍNICA DE ALERGIA E ASMA MARCO AURÉLIO RAMALHO BEZERRA', '123', '(81) 3221-5549', 'marcoaurelio', 'R Viscondessa do Livramento, 155 - Derby -\r\nRecife, PE - CEP: 52010-060', NULL),
(13, 'https://www.doctoralia.com.br/pergunta-efetuada/jefferson-correia-de-souza', 'Dr. Jefferson Correia de Souza', '123', '(81) 3241-6355, (81) 3427-0019', 'drjefferson', 'Rua Manoel Carvalho, 94, Aflitos , Recife', NULL),
(14, 'https://www.doctoralia.com.br/marilena-melo-cavalcanti/cardiologista-medico-clinicogeral/recife#address-id=[12266]', 'Dra. Marilena Melo Cavalcanti ', '123', '(81)\r\n3081-6767, (81) 3081-6780', 'dramarilena', 'R. do Futuro, 141, Graças , Recife', NULL),
(15, 'https://www.doctoralia.com.br/renata-brandao-2/hematologista/recife#address-id=[5\r\n90883]', 'Dra. Renata Brandão', '123', '(81) 3049-3915', 'drarenata', 'Rua Iramaia,\r\n1156, Ilha do Leite, Ilha Do Leite , Recife', NULL),
(16, 'http://www.jaymedafonte.com.br/consultorios/especialidades/18', 'Cláudio\r\nLacerda', '123', '3416-0075', 'claudiolacerda', 'Rua das Pernambucanas, 100, Graças\r\n- Recife', NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `doencas`
--

CREATE TABLE `doencas` (
  `id_doenca` int(11) NOT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `descricao` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `doencas`
--

INSERT INTO `doencas` (`id_doenca`, `nome`, `descricao`) VALUES
(1, 'Rinite ', 'Rinite é a irritação e inflamação da membrana mucosa no interior\r\nda cavidade nasal. Entre os sintomas mais comuns estão a congestão nasal, fluxo\r\nnasal abundante, espirros e acumulação de muco na garganta ou parte posterior do\r\nnariz.'),
(2, 'Dengue ', 'Dengue é uma doença febril grave causada por um arbovírus.\r\nArbovírus são vírus transmitidos por picadas de insetos, especialmente os\r\nmosquitos. Existem quatro tipos de vírus de dengue (sorotipos 1, 2, 3 e 4).'),
(3, 'Dermatite ', 'Dermatite é uma condição comum que não é contagiosa, mas\r\npode fazer com que você se sinta desconfortável. Uma combinação de medidas de\r\nautocuidado e medicamentos pode ajudá-lo a tratar a dermatite.'),
(4, 'Anemia ', 'Anemia é definida pela Organização Mundial de Saúde (OMS)\r\ncomo a condição na qual o conteúdo de hemoglobina no sangue está abaixo do\r\nnormal, levando à diminuição da capacidade de transporte de oxigênio. A\r\nhemoglobina é a substância que nosso corpo utiliza para transportar o oxigênio.'),
(5, 'Gripe', 'A gripe é causada pelo vírus influenza, que pode ser dos tipos A ou\r\nB. Cada uma dessas categorias se divide em outros subtipos – dentro do A, está o\r\nH1N1; e, do B, o Yamagata, por exemplo. Seus principais sintomas são febre alta,\r\ndor intensa no corpo, tosse, dor de garganta e cansaço.'),
(6, 'Pneumonia', 'A Pneumonia é uma infecção que se instala nos pulmões,\r\npodendo acometer a região dos alvéolos pulmonares. Alguns sintomas da doença\r\nsão: febre alta (acima de 37,5° C), tosse seca ou com catarro de cor amarelada ou\r\nesverdeada, falta de ar e dificuldade de respirar.'),
(7, 'Diabetes', 'A Diabetes é uma doença classificada como uma síndrome\r\nmetabólica que pode ter várias origens diferentes. Sua principal característica é a\r\nelevação da glicose no sangue por conta da ausência de insulina para controlá-la ou\r\npela incapacidade desse hormônio em exercer sua função no corpo.'),
(8, 'Asma', 'A Asma é uma das doenças inflamatórias crônicas mais comuns, a\r\nasma nada mais é do que uma inflamação das vias aéreas que persiste durante\r\nmuito tempo — e, às vezes, por toda a vida — em um indivíduo.'),
(9, 'Depressão', 'A depressão é uma das doenças da vida adulta mais\r\nnegligenciadas por pacientes e profissionais da saúde. Resumidamente, a\r\ndepressão se caracteriza por uma constante sensação de tristeza, pessimismo e\r\nbaixa autoestima.'),
(10, 'Hipertensão Arterial', 'A hipertensão arterial (popularmente conhecida\r\ncomo pressão alta) é uma doença que pode ter vários fatores responsáveis por seu\r\ndesenvolvimento, tanto comportamentais, quanto genéticos. Classifica-se como uma\r\npressão alta valores de pressão arterial igual ou acima de 140/90 milímetros de\r\nmercúrio. Essa é uma condição que atinge mais de 30% da população mundial,\r\nsendo mais comum em indivíduos do sexo masculino acima dos 60 anos.'),
(11, 'Bronquite', 'Bronquite é uma inflamação dos brônquios, canais que\r\nconduzem o ar inalado até os alvéolos pulmonares. Ela se instala quando os\r\nminúsculos cílios que revestem o interior dos brônquios param de eliminar o muco\r\npresente nas vias respiratórias. Esse acúmulo de secreção faz com que eles fiquem\r\npermanentemente inflamados e contraídos, provocando, principalmente, tosse. A\r\nbronquite pode ser aguda ou crônica. A diferença consiste na duração e\r\nagravamento das crises, que são mais curtas (uma ou duas semanas) na bronquite\r\naguda, enquanto, na crônica, não desaparecem, pioram pela manhã e se\r\nmanifestam por três meses ou mais durante pelo menos dois anos consecutivos.'),
(12, 'Insolação', 'A insolação é uma condição séria provocada pelo excesso de\r\nexposição ao sol e ao calor intenso. Ela acontece quando a temperatura corporal\r\nultrapassa os 40º C, fazendo com que o mecanismo de transpiração falhe e o corpo\r\nnão consega se resfriar.O quadro de insolação merece especial atenção porque\r\ncom o aumento rápido da temperatura corporal, a pessoa acaba perdendo muita\r\nágua, sais e nutrientes importantes para manutenção do equilíbrio do organismo.'),
(13, 'Zika', 'O vírus Zika é um arbovírus. Arbovírus são os vírus transmitidos por\r\npicadas de insetos, especialmente mosquitos. A doença pelo vírus Zika apresenta\r\nrisco superior a outras arboviroses, como dengue, febre amarela e chikungunya,\r\npara o desenvolvimento de complicações neurológicas, como encefalites, Síndrome\r\nde Guillain Barré e outras doenças neurológicas. Uma das principais complicações é\r\na microcefalia. A doença inicia com manchas vermelhas em todo o corpo, olho\r\nvermelho, pode causar febre baixa, dores pelo corpo e nas juntas, também de\r\npequena intensidade'),
(14, 'Caxumba', 'A caxumba é uma infecção viral aguda e contagiosa. Pode\r\natingir qualquer tecido glandular e nervoso do corpo humano, mas é mais comum\r\nafetar as glândulas parótidas, que produzem a saliva, ou as submandibulares e\r\nsublinguais, próximas ao ouvido. A caxumba, também conhecida como Papeira, é\r\numa doença de distribuição universal, de alta morbidade e baixa letalidade,\r\naparecendo sob a forma endêmica ou surtos.'),
(15, 'Sarampo', 'O sarampo é uma virose – um vírus com genoma RNA\r\n(paramyxovirus do grupo morbillivirus). Como a maior parte das doenças de\r\ndisseminação respiratória, o sarampo era bem mais comum no inverno pela maior\r\naglomeração de pessoas. A doença está bem controlada no Brasil e os casos que\r\naparecem são importados ou secundários a importados.'),
(16, 'Catarata', 'O termo “catarata” é dado para qualquer tipo de perda de\r\ntransparência do cristalino, lente situada atrás da íris (Figura), seja ela congênita ou\r\nadquirida, independente de causar ou não prejuízos à visão. Segundo a\r\nOrganização Mundial de Saúde (OMS), a catarata é responsável por 47,8% dos\r\ncasos de cegueira no mundo, acometendo principalmente a população idosa.'),
(17, 'Conjuntivite', 'Conjuntivite é a inflamação da membrana externa do globo\r\nocular (o branco dos olhos) e no interior das pálpebras. Os principais sintomas da\r\nconjuntivite são vermelhidão nos olhos, coceira e olhos lacrimejantes; e, em geral,\r\nataca os dois olhos, dura até 15 dias e não costuma deixar sequelas.'),
(18, 'Otite', ' A otite, refere-se a uma inflamação no ouvido médio, que é um\r\npequeno espaço cheio de ar localizado atrás do tímpano. Essa inflamação se\r\ndesenvolve devido ao acúmulo de secreção e ocasiona fortes dores na região.'),
(19, 'Herpes Labial', 'O herpes labial é uma infecção dolorosa causada pelo\r\nvírus do herpes simples. Também conhecida como bolhas de febre, essas bolhas\r\npodem aparecer em qualquer parte do corpo, porém são mais comuns no exterior\r\nda boca e nos lábios. Após a formação das bolhas, elas se rompem para formar\r\numa ferida contagiosa que dura entre sete a dez dias antes de encrostar.'),
(20, 'Cirrose', 'Cirrose é uma doença crônica do fígado que se caracteriza por\r\nfibrose e formação de nódulos que bloqueiam a circulação sanguínea. Pode ser\r\ncausada por infecções ou inflamação crônica dessa glândula. A cirrose faz com que\r\no fígado produza tecido de cicatrização no lugar das células saudáveis que\r\nmorrem.'),
(21, 'Apendicite', 'A apendicite, é uma inflamação dolorosa no apêndice, uma\r\nbolsinha localizada do lado direito do intestino grosso. O problema acontece quando\r\nalgum corpo estranho — pequenas porções de fezes, um parasita ou até sementes\r\nde frutas — obstrui essa estrutura, levando a um inchaço e ao aparecimento de um\r\nabcesso em sua ponta. Ali contida, a secreção favorece a proliferação de\r\nbactérias.'),
(22, 'Sífilis', 'A sífilis é uma Infecção Sexualmente Transmissível (IST) curável e\r\nexclusiva do ser humano, causada pela bactéria Treponema pallidum. Pode\r\napresentar várias manifestações clínicas e diferentes estágios (sífilis primária,\r\nsecundária, latente e terciária).'),
(23, 'Amigdalite', 'A amigdalite é a inflamação das amígdalas, causando\r\ninchaço, pus, mau hálito, dor de garganta e até febre. É uma doença que pode\r\nafetar pessoas de qualquer idade, especialmente crianças.'),
(24, 'Rubéola', 'A rubéola é uma doença aguda, de alta contagiosidade, que é\r\ntransmitida pelo vírus do gênero Rubivirus, da família Togaviridae. A doença\r\ntambém é conhecida como “Sarampo Alemão”.'),
(25, 'Gastrite', 'Gastrite é a inflamação da mucosa que reveste as paredes\r\ninternas do estômago. Ela pode ser aguda ou crônica e é provocada por diferentes\r\nfatores, entre eles: Uso prolongado de ácido acetilsalicílico (AAS) e de\r\nanti-inflamatórios (incluindo corticóides)');

-- --------------------------------------------------------

--
-- Estrutura da tabela `doenca_especialidade`
--

CREATE TABLE `doenca_especialidade` (
  `id_doenca_especialidade` int(11) NOT NULL,
  `doenca_id` int(11) NOT NULL,
  `especialidade_id` int(11) NOT NULL,
  `clinica_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `doenca_especialidade`
--

INSERT INTO `doenca_especialidade` (`id_doenca_especialidade`, `doenca_id`, `especialidade_id`, `clinica_id`) VALUES
(1, 1, 4, 4),
(2, 1, 5, 5),
(3, 2, 13, 13),
(4, 2, 14, 14),
(5, 3, 6, 6),
(6, 4, 15, 15),
(7, 5, 4, 4),
(8, 5, 5, 5),
(9, 6, 1, 1),
(10, 7, 11, 11),
(11, 8, 1, 1),
(12, 8, 2, 2),
(13, 9, 10, 10),
(14, 10, 14, 14),
(15, 11, 1, 1),
(16, 12, 6, 6),
(17, 12, 2, 2),
(18, 13, 13, 13),
(19, 13, 14, 14),
(20, 14, 13, 13),
(21, 14, 14, 14),
(22, 15, 13, 13),
(23, 15, 14, 14),
(24, 16, 7, 7),
(25, 16, 8, 8),
(26, 17, 7, 7),
(27, 17, 8, 8),
(28, 18, 4, 4),
(29, 18, 5, 5),
(30, 19, 6, 6),
(31, 20, 16, 16),
(32, 21, 13, 13),
(33, 21, 14, 14),
(34, 22, 3, 3),
(35, 23, 4, 4),
(36, 23, 5, 5),
(37, 24, 13, 13),
(38, 24, 14, 14),
(39, 25, 9, 9);

-- --------------------------------------------------------

--
-- Estrutura da tabela `doenca_sintoma`
--

CREATE TABLE `doenca_sintoma` (
  `id_doenca_sintoma` int(11) NOT NULL,
  `doenca_id` int(11) NOT NULL,
  `sintoma_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `doenca_sintoma`
--

INSERT INTO `doenca_sintoma` (`id_doenca_sintoma`, `doenca_id`, `sintoma_id`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 1, 3),
(4, 1, 96),
(5, 1, 4),
(6, 1, 5),
(7, 1, 6),
(8, 1, 7),
(9, 2, 24),
(10, 2, 95),
(11, 2, 8),
(12, 2, 9),
(13, 2, 10),
(14, 2, 11),
(15, 2, 12),
(16, 3, 12),
(17, 3, 13),
(18, 3, 84),
(19, 3, 14),
(20, 4, 6),
(21, 4, 10),
(22, 4, 62),
(23, 4, 15),
(24, 4, 16),
(25, 4, 17),
(26, 4, 18),
(27, 4, 19),
(28, 4, 20),
(29, 4, 11),
(30, 4, 21),
(31, 4, 22),
(32, 4, 23),
(33, 5, 24),
(34, 5, 95),
(35, 5, 93),
(36, 5, 11),
(37, 5, 39),
(38, 5, 6),
(39, 5, 1),
(40, 5, 96),
(41, 6, 24),
(42, 6, 39),
(43, 6, 17),
(44, 6, 19),
(45, 6, 9),
(46, 6, 65),
(47, 6, 25),
(48, 6, 86),
(49, 7, 26),
(50, 7, 27),
(51, 7, 28),
(52, 7, 87),
(53, 7, 29),
(54, 7, 30),
(55, 7, 31),
(56, 7, 32),
(57, 8, 40),
(58, 8, 33),
(59, 8, 19),
(60, 8, 17),
(61, 8, 34),
(62, 8, 35),
(63, 8, 36),
(64, 8, 37),
(65, 8, 38),
(66, 8, 39),
(67, 9, 40),
(68, 9, 21),
(69, 9, 41),
(70, 9, 42),
(71, 9, 43),
(72, 9, 44),
(73, 9, 45),
(74, 9, 46),
(75, 9, 47),
(76, 9, 48),
(77, 9, 49),
(78, 9, 10),
(79, 9, 50),
(80, 9, 51),
(81, 9, 52),
(82, 9, 53),
(83, 9, 54),
(84, 10, 11),
(85, 10, 19),
(86, 10, 18),
(87, 10, 31),
(88, 10, 55),
(89, 11, 17),
(90, 11, 56),
(91, 11, 66),
(92, 11, 93),
(93, 12, 11),
(94, 12, 18),
(95, 12, 86),
(96, 12, 57),
(97, 12, 58),
(98, 12, 59),
(99, 12, 60),
(100, 12, 61),
(101, 12, 35),
(102, 12, 62),
(103, 12, 63),
(104, 12, 64),
(105, 12, 65),
(106, 13, 104),
(107, 13, 66),
(108, 13, 103),
(109, 13, 11),
(110, 13, 67),
(111, 14, 66),
(112, 14, 11),
(113, 14, 6),
(114, 14, 65),
(115, 14, 10),
(116, 14, 68),
(117, 15, 66),
(118, 15, 2),
(119, 15, 69),
(120, 15, 70),
(121, 15, 9),
(122, 16, 31),
(123, 16, 71),
(124, 17, 72),
(125, 17, 73),
(126, 17, 74),
(127, 17, 75),
(128, 17, 76),
(129, 17, 77),
(130, 17, 13),
(131, 18, 78),
(132, 18, 66),
(133, 18, 79),
(134, 18, 10),
(135, 18, 80),
(136, 18, 11),
(137, 18, 81),
(138, 18, 82),
(139, 19, 83),
(140, 19, 84),
(141, 19, 85),
(142, 19, 13),
(143, 20, 86),
(144, 20, 80),
(145, 20, 87),
(146, 20, 88),
(147, 20, 89),
(148, 20, 6),
(149, 20, 90),
(150, 20, 91),
(151, 20, 92),
(152, 21, 93),
(153, 21, 89),
(154, 21, 10),
(155, 21, 66),
(156, 21, 94),
(157, 21, 86),
(158, 22, 95),
(159, 22, 96),
(160, 22, 97),
(161, 22, 98),
(162, 22, 99),
(163, 22, 12),
(164, 23, 100),
(165, 23, 96),
(166, 23, 68),
(167, 23, 66),
(168, 23, 101),
(169, 23, 11),
(170, 24, 24),
(171, 24, 1),
(172, 24, 2),
(173, 24, 11),
(174, 24, 9),
(175, 24, 102),
(176, 24, 103),
(177, 24, 104),
(178, 25, 105),
(179, 25, 106),
(180, 25, 107),
(181, 25, 108),
(182, 25, 11),
(183, 25, 9),
(184, 25, 80),
(185, 25, 109),
(186, 25, 110);

-- --------------------------------------------------------

--
-- Estrutura da tabela `doenca_sub_area_sintoma`
--

CREATE TABLE `doenca_sub_area_sintoma` (
  `id_doenca_sub_area_sintoma` int(11) NOT NULL,
  `doenca_id` int(11) NOT NULL,
  `sub_area_sintoma_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `doenca_sub_area_sintoma`
--

INSERT INTO `doenca_sub_area_sintoma` (`id_doenca_sub_area_sintoma`, `doenca_id`, `sub_area_sintoma_id`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 1, 3),
(4, 1, 4),
(5, 1, 5),
(6, 1, 6),
(7, 1, 7),
(8, 1, 89),
(9, 2, 29),
(10, 2, 83),
(11, 2, 84),
(12, 2, 85),
(13, 2, 86),
(14, 2, 87),
(15, 2, 88),
(16, 2, 8),
(17, 2, 9),
(18, 2, 10),
(19, 2, 11),
(20, 2, 12),
(21, 3, 12),
(22, 3, 13),
(23, 3, 74),
(24, 3, 14),
(25, 4, 6),
(26, 4, 10),
(27, 4, 56),
(28, 4, 15),
(29, 4, 16),
(30, 4, 17),
(31, 4, 18),
(32, 4, 19),
(33, 4, 20),
(34, 4, 21),
(35, 4, 22),
(36, 4, 27),
(37, 4, 28),
(38, 4, 11),
(39, 4, 23),
(40, 4, 24),
(41, 4, 25),
(42, 4, 26),
(43, 5, 29),
(44, 5, 83),
(45, 5, 84),
(46, 5, 85),
(47, 5, 86),
(48, 5, 87),
(49, 5, 88),
(50, 5, 82),
(51, 5, 11),
(52, 5, 41),
(53, 5, 6),
(54, 5, 1),
(55, 5, 89),
(56, 6, 29),
(57, 6, 41),
(58, 6, 16),
(59, 6, 18),
(60, 6, 9),
(61, 6, 58),
(62, 6, 30),
(63, 6, 75),
(64, 7, 31),
(65, 7, 32),
(66, 7, 33),
(67, 7, 76),
(68, 7, 34),
(69, 7, 35),
(70, 7, 36),
(71, 8, 42),
(72, 8, 18),
(73, 8, 16),
(74, 8, 37),
(75, 8, 38),
(76, 8, 39),
(77, 8, 40),
(78, 8, 41),
(79, 9, 42),
(80, 9, 23),
(81, 9, 43),
(82, 9, 44),
(83, 9, 45),
(84, 9, 10),
(85, 9, 46),
(86, 9, 47),
(87, 9, 48),
(88, 10, 11),
(89, 10, 18),
(90, 10, 17),
(91, 10, 36),
(92, 10, 49),
(93, 11, 16),
(94, 11, 50),
(95, 11, 59),
(96, 11, 82),
(97, 12, 11),
(98, 12, 17),
(99, 12, 75),
(100, 12, 51),
(101, 12, 52),
(102, 12, 53),
(103, 12, 54),
(104, 12, 55),
(105, 12, 38),
(106, 12, 56),
(107, 12, 57),
(108, 12, 58),
(109, 13, 95),
(110, 13, 59),
(111, 13, 94),
(112, 13, 11),
(113, 13, 60),
(114, 14, 59),
(115, 14, 11),
(116, 14, 6),
(117, 14, 58),
(118, 14, 10),
(119, 14, 61),
(120, 15, 59),
(121, 15, 2),
(122, 15, 62),
(123, 15, 63),
(124, 15, 9),
(125, 16, 36),
(126, 16, 64),
(127, 17, 65),
(128, 17, 66),
(129, 17, 67),
(130, 17, 13),
(131, 18, 68),
(132, 18, 59),
(133, 18, 69),
(134, 18, 10),
(135, 18, 70),
(136, 18, 11),
(137, 18, 71),
(138, 18, 72),
(139, 19, 73),
(140, 19, 74),
(141, 19, 13),
(142, 20, 75),
(143, 20, 70),
(144, 20, 76),
(145, 20, 77),
(146, 20, 6),
(147, 20, 78),
(148, 20, 79),
(149, 20, 80),
(150, 20, 81),
(151, 21, 82),
(152, 21, 10),
(153, 21, 59),
(154, 21, 75),
(155, 22, 83),
(156, 22, 84),
(157, 22, 85),
(158, 22, 86),
(159, 22, 87),
(160, 22, 88),
(161, 22, 89),
(162, 22, 90),
(163, 22, 12),
(164, 23, 91),
(165, 23, 89),
(166, 23, 61),
(167, 23, 59),
(168, 23, 92),
(169, 23, 11),
(170, 24, 29),
(171, 24, 1),
(172, 24, 2),
(173, 24, 11),
(174, 24, 9),
(175, 24, 93),
(176, 24, 94),
(177, 24, 95),
(178, 25, 96),
(179, 25, 97),
(180, 25, 98),
(181, 25, 99),
(182, 25, 11),
(183, 25, 9),
(184, 25, 70);

-- --------------------------------------------------------

--
-- Estrutura da tabela `especialidade`
--

CREATE TABLE `especialidade` (
  `id_especialidade` int(11) NOT NULL,
  `nome` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `especialidade`
--

INSERT INTO `especialidade` (`id_especialidade`, `nome`) VALUES
(1, 'Avaliação de Risco Cirurgico Pulmonar, Pulmões, Pneumologia, Função\r\nPulmonar.'),
(2, 'Consultas e Procedimentos, Médicos e Ondotológicos'),
(3, 'Ginecologia'),
(4, 'Otorrinolaringologistas (Ouvidos, Nariz e Garganta)'),
(5, 'Otorrinolaringologistas (Ouvidos, Nariz e Garganta)'),
(6, 'Dermatologia'),
(7, 'Olhos'),
(8, 'Olhos'),
(9, 'Gastroenterologista'),
(10, 'Psiquiatria'),
(11, 'Endocrinologistas e Metabologistas'),
(12, 'Alergologistas e Imunologistas'),
(13, 'Oncologista, Médico clínico geral'),
(14, 'Cardiologista, Médico clínico geral'),
(15, 'Hematologista'),
(16, 'Hepatologia');

-- --------------------------------------------------------

--
-- Estrutura da tabela `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(7),
(7),
(7),
(7),
(7);

-- --------------------------------------------------------

--
-- Estrutura da tabela `sintomas`
--

CREATE TABLE `sintomas` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `sintomas`
--

INSERT INTO `sintomas` (`id`, `nome`) VALUES
(1, 'Congestão nasal'),
(2, 'Tosse'),
(3, 'Diminuição da audição e diminuição do olfato'),
(4, 'Olheiras'),
(5, 'Olhos inchados'),
(6, 'Fadiga'),
(7, 'Cefaleia'),
(8, 'Dor ao movimentar os olhos'),
(9, 'Mal estar'),
(10, 'Falta de apetite'),
(11, 'Dor de cabeça'),
(12, 'Manchas vermelhas no corpo'),
(13, 'Coceira'),
(14, 'Dor ou sensibilidade'),
(15, 'Menor disposição para o trabalho'),
(16, 'Dificuldade de aprendizagem nas crianças'),
(17, 'Falta de ar'),
(18, 'Tonturas'),
(19, 'Dor no peito'),
(20, 'Mãos e pés frios'),
(21, 'Apatia. (crianças muito \"paradas\")'),
(22, 'Vontade de comer substâncias não alimentares, como gelo ou arroz cru'),
(23, 'Formigamento nas mãos e pés.'),
(24, 'Febre alta (Acima de 38° C)'),
(25, 'Suores intensos, principalmente a noite'),
(26, 'Fome constante'),
(27, 'Formigamento em membros inferiores e superiores'),
(28, 'Infecções corporais frequentes'),
(29, 'Problemas de cicatrização'),
(30, 'Sensação excessiva de sede'),
(31, 'Visão embaçada'),
(32, 'Vontade frequente de urinar'),
(33, 'Confusão'),
(34, 'Lábios e rostos azulados (como se estivessem sem ar)'),
(35, 'Respiração ofegante'),
(36, 'Sonolência'),
(37, 'Sudorese'),
(38, 'Tosse com muco'),
(39, 'Tosse seca'),
(40, 'Ansiedade e angústia'),
(41, 'Baixa autoestima'),
(42, 'Desejo de morrer'),
(43, 'Dificuldade de concentração'),
(44, 'Falta de motivação'),
(45, 'Falta de vontade'),
(46, 'Humor bastante variável'),
(47, 'Incapacidade de sentir alegria ou prazer'),
(48, 'Insônia'),
(49, 'Irritabilidade'),
(50, 'Pessimismo'),
(51, 'Queda da libido'),
(52, 'Sensação de desânimo e cansaço'),
(53, 'Sensação de falta de sentido na vida'),
(54, 'Sentimento de medo, insegurança ou vazio'),
(55, 'Zumbido no ouvido'),
(56, 'Chiado ao respirar'),
(57, 'Pele quente e seca'),
(58, 'Pulso rápido'),
(59, 'Temperatura elevada'),
(60, 'Distúrbios visuais'),
(61, 'Confusão mental'),
(62, 'Palidez (às vezes desmaio)'),
(63, 'Convulsão'),
(64, 'Extremidades arroxeadas'),
(65, 'Fraqueza muscular'),
(66, 'Febre'),
(67, 'Dor nas juntas'),
(68, 'Dor ao mastigar e engolir'),
(69, 'Irritação nos olhos'),
(70, 'Nariz escorrendo ou entupido'),
(71, 'Sensibilidade à luz'),
(72, 'Vermelhidão nos olhos'),
(73, 'Olhos lacrimejantes'),
(74, 'Pálpebras inchadas'),
(75, 'Secreção purulenta (conjuntivite bacteriana)'),
(76, 'Sensação de areia ou de ciscos nos olhos'),
(77, 'Secreção esbranquiçada (conjuntivite viral)'),
(78, 'Dor de ouvido (leve a grave). Os bebês muitas vezes puxam seus ouvidos\r\nquando sente dor'),
(79, 'Líquido espesso e amarelado ou sanguinolento saindo do ouvido. Isso\r\nsignifica que o tímpano provave'),
(80, 'Vômitos'),
(81, 'Comportamento mal-humorado'),
(82, 'Problemas para dormir'),
(83, 'Lesões na pele, lábios, boca e gengiva'),
(84, 'Bolhas doloridas que se rompem e liberam fluido'),
(85, 'Crostas amarelas que se soltam e mostram uma pele rosa em\r\ncicatrização'),
(86, 'Náuseas'),
(87, 'Perda de Peso'),
(88, 'Dor abdominal'),
(89, 'Constipação'),
(90, 'Fígado aumentado'),
(91, 'Olhos e Peles amarelados'),
(92, 'Inchaço nas pernas'),
(93, 'Calafrios'),
(94, 'Tremores'),
(95, 'Dores musculares'),
(96, 'Dor de garganta'),
(97, 'Formigamento'),
(98, 'Aparecimento de nódulos'),
(99, 'Feridas indolores'),
(100, 'Placas brancas nas amígdalas'),
(101, 'Nódulos linfáticos no pescoço'),
(102, 'Gânglios aumentados, especialmente próximos ao pescoço'),
(103, 'Conjuntivite'),
(104, 'Manchas vermelhas na pele que causam coceira'),
(105, 'Dores estomacais fortes, em forma de pontadas'),
(106, 'Má digestão, com a sensação de que a comida está parada no estômago'),
(107, 'Azia'),
(108, 'Arrotos frequentes'),
(109, 'Saciedade precoce'),
(110, 'Endoscopia digestiva');

-- --------------------------------------------------------

--
-- Estrutura da tabela `sub_area`
--

CREATE TABLE `sub_area` (
  `id` int(11) NOT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `area_id` int(11) NOT NULL,
  `frente` tinyint(1) NOT NULL,
  `costas` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `sub_area`
--

INSERT INTO `sub_area` (`id`, `nome`, `area_id`, `frente`, `costas`) VALUES
(1, 'Olhos', 1, 1, 0),
(2, 'Orelhas', 1, 1, 1),
(3, 'Nariz', 1, 1, 0),
(4, 'Boca', 1, 1, 0),
(5, 'Nuca', 1, 0, 1),
(6, 'Cabeça em geral', 1, 1, 1),
(7, 'Pescoço', 1, 1, 1),
(8, 'Peito', 2, 1, 0),
(9, 'Barriga', 2, 1, 0),
(10, 'Costas', 2, 0, 1),
(11, 'Umbigo', 2, 1, 0),
(12, 'Ombro', 3, 1, 1),
(13, 'Braço', 3, 1, 1),
(14, 'Ante-braço', 3, 1, 1),
(15, 'Mão', 3, 1, 1),
(16, 'Ombro', 4, 1, 1),
(17, 'Braço', 4, 1, 1),
(18, 'Ante-braço', 4, 1, 1),
(19, 'Mão', 4, 1, 1),
(20, 'Coxa', 5, 1, 1),
(21, 'Joelho', 5, 1, 1),
(22, 'Canela', 5, 1, 1),
(23, 'Pé', 5, 1, 1),
(24, 'Coxa', 6, 1, 1),
(25, 'Joelho', 6, 1, 1),
(26, 'Canela', 6, 1, 1),
(27, 'Pé', 6, 1, 1),
(28, 'Corpo em geral', 2, 1, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `sub_area_sintoma`
--

CREATE TABLE `sub_area_sintoma` (
  `id_sub_area_sintoma` int(11) NOT NULL,
  `sub_area_id` int(11) NOT NULL,
  `sintoma_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `sub_area_sintoma`
--

INSERT INTO `sub_area_sintoma` (`id_sub_area_sintoma`, `sub_area_id`, `sintoma_id`) VALUES
(1, 3, 1),
(2, 4, 2),
(3, 2, 3),
(4, 1, 4),
(5, 1, 5),
(6, 28, 6),
(7, 6, 7),
(8, 1, 8),
(9, 28, 9),
(10, 9, 10),
(11, 6, 11),
(12, 28, 12),
(13, 28, 13),
(14, 28, 14),
(15, 28, 15),
(16, 3, 17),
(17, 28, 18),
(18, 8, 19),
(19, 15, 20),
(20, 23, 20),
(21, 19, 20),
(22, 27, 20),
(23, 28, 21),
(24, 9, 22),
(25, 15, 23),
(26, 23, 23),
(27, 19, 20),
(28, 27, 20),
(29, 28, 24),
(30, 28, 25),
(31, 9, 26),
(32, 28, 27),
(33, 28, 28),
(34, 28, 29),
(35, 4, 30),
(36, 1, 31),
(37, 4, 34),
(38, 3, 35),
(39, 28, 36),
(40, 4, 38),
(41, 4, 39),
(42, 28, 40),
(43, 28, 46),
(44, 28, 48),
(45, 28, 49),
(46, 28, 50),
(47, 28, 51),
(48, 28, 52),
(49, 2, 55),
(50, 3, 56),
(51, 28, 57),
(52, 28, 58),
(53, 28, 59),
(54, 1, 60),
(55, 6, 61),
(56, 28, 62),
(57, 28, 64),
(58, 28, 65),
(59, 28, 66),
(60, 10, 67),
(61, 4, 68),
(62, 1, 69),
(63, 3, 70),
(64, 1, 71),
(65, 1, 72),
(66, 1, 73),
(67, 1, 74),
(68, 2, 78),
(69, 2, 79),
(70, 4, 80),
(71, 28, 81),
(72, 28, 82),
(73, 4, 83),
(74, 28, 84),
(75, 28, 86),
(76, 28, 87),
(77, 9, 88),
(78, 9, 90),
(79, 1, 91),
(80, 20, 92),
(81, 24, 92),
(82, 28, 93),
(83, 12, 95),
(84, 13, 95),
(85, 14, 95),
(86, 16, 95),
(87, 17, 95),
(88, 18, 95),
(89, 7, 96),
(90, 28, 99),
(91, 4, 100),
(92, 7, 101),
(93, 7, 102),
(94, 1, 103),
(95, 28, 104),
(96, 9, 105),
(97, 9, 106),
(98, 7, 107),
(99, 4, 108);

-- --------------------------------------------------------

--
-- Estrutura da tabela `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `birthdate` date DEFAULT NULL,
  `email` varchar(200) NOT NULL,
  `name` varchar(200) NOT NULL,
  `neighborhood` varchar(200) NOT NULL,
  `number` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  `state` varchar(200) NOT NULL,
  `street` varchar(200) NOT NULL,
  `telephone` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `user`
--

INSERT INTO `user` (`id`, `birthdate`, `email`, `name`, `neighborhood`, `number`, `password`, `state`, `street`, `telephone`) VALUES
(1, '1996-05-14', 'elthonferreira18@gmail.com', 'Elthon Ferreira', 'Centro', '74', '123', 'São Lourenço da Mata-PE', 'Rua Virgílio Santiago', '(81) 99872-0773'),
(2, '1984-06-24', 'ederlucenafonseca@gmail.com', 'Eder Lucena', 'Bairro 1', '75', '123', 'Camaragibe-PE', 'Rua 1', '(81) 99826-5133'),
(3, '1997-09-03', 'amaurytavares16@gmail.com', 'Amaury Tavares', 'Bairro 2', '76', '123', 'Limoeiro-PE', 'Rua 2', '(81) 99454-6857'),
(4, '1996-08-21', 'paixomaik6gmail.com', 'Maik Luiz', 'Bairro 3', '77', '123', 'Jaboatão dos Guararapes-PE', 'Rua 3', '(81) 98743-6058'),
(5, '1993-11-20', 'marcoseduflautista1@gmail.com', 'Marcos Eduardo', 'Bairro\r\n4', '78', '123', 'Recife-PE', 'Rua 4', '(81) 99679-5183'),
(6, '1985-10-02', 'suzana.sampaio@gmail.com', 'Suzana Sampaio', 'Bairro 5', '79', '123', 'Recife-PE', 'Rua 5', '(81)********');

-- --------------------------------------------------------

--
-- Estrutura da tabela `user_sub_area_sintoma`
--

CREATE TABLE `user_sub_area_sintoma` (
  `id_user_sub_area_sintoma` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `sub_area_sintoma_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `user_sub_area_sintoma`
--

INSERT INTO `user_sub_area_sintoma` (`id_user_sub_area_sintoma`, `user_id`, `sub_area_sintoma_id`) VALUES
(1, 3, 1),
(2, 3, 68),
(3, 3, 86),
(4, 3, 5),
(5, 3, 49),
(6, 3, 38);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `area`
--
ALTER TABLE `area`
  ADD PRIMARY KEY (`id_area`);

--
-- Índices para tabela `clinica`
--
ALTER TABLE `clinica`
  ADD PRIMARY KEY (`id_clinica`);

--
-- Índices para tabela `doencas`
--
ALTER TABLE `doencas`
  ADD PRIMARY KEY (`id_doenca`);

--
-- Índices para tabela `doenca_especialidade`
--
ALTER TABLE `doenca_especialidade`
  ADD PRIMARY KEY (`id_doenca_especialidade`),
  ADD KEY `doenca_id` (`doenca_id`),
  ADD KEY `especialidade_id` (`especialidade_id`),
  ADD KEY `clinica_id` (`clinica_id`);

--
-- Índices para tabela `doenca_sintoma`
--
ALTER TABLE `doenca_sintoma`
  ADD PRIMARY KEY (`id_doenca_sintoma`),
  ADD KEY `doenca_id` (`doenca_id`),
  ADD KEY `sintoma_id` (`sintoma_id`);

--
-- Índices para tabela `doenca_sub_area_sintoma`
--
ALTER TABLE `doenca_sub_area_sintoma`
  ADD PRIMARY KEY (`id_doenca_sub_area_sintoma`),
  ADD KEY `doenca_id` (`doenca_id`),
  ADD KEY `sub_area_sintoma_id` (`sub_area_sintoma_id`);

--
-- Índices para tabela `especialidade`
--
ALTER TABLE `especialidade`
  ADD PRIMARY KEY (`id_especialidade`);

--
-- Índices para tabela `sintomas`
--
ALTER TABLE `sintomas`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `sub_area`
--
ALTER TABLE `sub_area`
  ADD PRIMARY KEY (`id`),
  ADD KEY `area_id` (`area_id`);

--
-- Índices para tabela `sub_area_sintoma`
--
ALTER TABLE `sub_area_sintoma`
  ADD PRIMARY KEY (`id_sub_area_sintoma`),
  ADD KEY `sub_area_id` (`sub_area_id`),
  ADD KEY `sintoma_id` (`sintoma_id`);

--
-- Índices para tabela `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `user_sub_area_sintoma`
--
ALTER TABLE `user_sub_area_sintoma`
  ADD PRIMARY KEY (`id_user_sub_area_sintoma`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `sub_area_sintoma_id` (`sub_area_sintoma_id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `area`
--
ALTER TABLE `area`
  MODIFY `id_area` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de tabela `clinica`
--
ALTER TABLE `clinica`
  MODIFY `id_clinica` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de tabela `doencas`
--
ALTER TABLE `doencas`
  MODIFY `id_doenca` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT de tabela `doenca_especialidade`
--
ALTER TABLE `doenca_especialidade`
  MODIFY `id_doenca_especialidade` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- AUTO_INCREMENT de tabela `doenca_sintoma`
--
ALTER TABLE `doenca_sintoma`
  MODIFY `id_doenca_sintoma` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=187;

--
-- AUTO_INCREMENT de tabela `doenca_sub_area_sintoma`
--
ALTER TABLE `doenca_sub_area_sintoma`
  MODIFY `id_doenca_sub_area_sintoma` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=185;

--
-- AUTO_INCREMENT de tabela `especialidade`
--
ALTER TABLE `especialidade`
  MODIFY `id_especialidade` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de tabela `sintomas`
--
ALTER TABLE `sintomas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=111;

--
-- AUTO_INCREMENT de tabela `sub_area`
--
ALTER TABLE `sub_area`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT de tabela `sub_area_sintoma`
--
ALTER TABLE `sub_area_sintoma`
  MODIFY `id_sub_area_sintoma` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=100;

--
-- AUTO_INCREMENT de tabela `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `user_sub_area_sintoma`
--
ALTER TABLE `user_sub_area_sintoma`
  MODIFY `id_user_sub_area_sintoma` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `doenca_especialidade`
--
ALTER TABLE `doenca_especialidade`
  ADD CONSTRAINT `doenca_especialidade_ibfk_1` FOREIGN KEY (`doenca_id`) REFERENCES `doencas` (`id_doenca`),
  ADD CONSTRAINT `doenca_especialidade_ibfk_2` FOREIGN KEY (`especialidade_id`) REFERENCES `especialidade` (`id_especialidade`),
  ADD CONSTRAINT `doenca_especialidade_ibfk_3` FOREIGN KEY (`clinica_id`) REFERENCES `clinica` (`id_clinica`);

--
-- Limitadores para a tabela `doenca_sintoma`
--
ALTER TABLE `doenca_sintoma`
  ADD CONSTRAINT `doenca_sintoma_ibfk_1` FOREIGN KEY (`doenca_id`) REFERENCES `doencas` (`id_doenca`),
  ADD CONSTRAINT `doenca_sintoma_ibfk_2` FOREIGN KEY (`sintoma_id`) REFERENCES `sintomas` (`id`);

--
-- Limitadores para a tabela `doenca_sub_area_sintoma`
--
ALTER TABLE `doenca_sub_area_sintoma`
  ADD CONSTRAINT `doenca_sub_area_sintoma_ibfk_1` FOREIGN KEY (`doenca_id`) REFERENCES `doencas` (`id_doenca`),
  ADD CONSTRAINT `doenca_sub_area_sintoma_ibfk_2` FOREIGN KEY (`sub_area_sintoma_id`) REFERENCES `sub_area_sintoma` (`id_sub_area_sintoma`);

--
-- Limitadores para a tabela `sub_area`
--
ALTER TABLE `sub_area`
  ADD CONSTRAINT `sub_area_ibfk_1` FOREIGN KEY (`area_id`) REFERENCES `area` (`id_area`);

--
-- Limitadores para a tabela `sub_area_sintoma`
--
ALTER TABLE `sub_area_sintoma`
  ADD CONSTRAINT `sub_area_sintoma_ibfk_1` FOREIGN KEY (`sub_area_id`) REFERENCES `sub_area` (`id`),
  ADD CONSTRAINT `sub_area_sintoma_ibfk_2` FOREIGN KEY (`sintoma_id`) REFERENCES `sintomas` (`id`);

--
-- Limitadores para a tabela `user_sub_area_sintoma`
--
ALTER TABLE `user_sub_area_sintoma`
  ADD CONSTRAINT `user_sub_area_sintoma_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `user_sub_area_sintoma_ibfk_2` FOREIGN KEY (`sub_area_sintoma_id`) REFERENCES `sub_area_sintoma` (`id_sub_area_sintoma`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
